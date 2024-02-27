package com.icomfortableworld.domain.feed.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icomfortableworld.domain.feed.dto.requestDto.FeedRequestDto;
import com.icomfortableworld.domain.feed.dto.responseDto.FeedResponseDto;
import com.icomfortableworld.domain.feed.entity.Feed;
import com.icomfortableworld.domain.feed.model.FeedModel;
import com.icomfortableworld.domain.feed.repository.FeedRepository;
import com.icomfortableworld.domain.member.entity.Member;
import com.icomfortableworld.domain.member.model.MemberModel;
import com.icomfortableworld.domain.member.repository.MemberRepository;
import com.icomfortableworld.domain.tag.entity.Tag;
import com.icomfortableworld.domain.tag.entity.TagSet;
import com.icomfortableworld.domain.tag.repository.TagRepository;
import com.icomfortableworld.domain.tag.repository.TagSetRepository;
import com.icomfortableworld.global.exception.feed.CustomFeedException;
import com.icomfortableworld.global.exception.feed.FeedErrorCode;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class FeedServiceImpl implements FeedService {

	private final FeedRepository feedRepository;
	private final MemberRepository memberRepository;
	private final TagRepository tagRepository;
	private final TagSetRepository tagSetRepository;

	@Override
	public void createFeed(FeedRequestDto requestDto, Long memberId) {
		memberRepository.findByIdOrElseThrow(memberId);
		FeedModel feedModel = feedRepository.save(new Feed(requestDto, memberId)).toModel();

		for (String tagName : requestDto.getTagNameList()) {
			//없으면 만들어주기~
			TagSet tagSet = tagSetRepository.findByTagName(tagName).orElse(null);
			if (tagSet == null) {
				tagSet = tagSetRepository.save(new TagSet(tagName));
			}
			Tag tag = new Tag(feedModel.getFeedId(), tagSet.getTagSetId());
			tagRepository.save(tag);
		}
	}

	@Override
	public FeedResponseDto updateFeed(Long feedId, FeedRequestDto requestDto, Long memberId) {
		memberRepository.findByIdOrElseThrow(memberId);
		String content = requestDto.getContent();

		FeedModel feedModel = feedRepository.update(feedId, memberId, content);

		return new FeedResponseDto(feedModel.getContent(), new ArrayList<>());
	}

	@Override
	public List<FeedResponseDto> getAllFeeds(Long memberId) {
		memberRepository.findByIdOrElseThrow(memberId);

		List<FeedModel> feedModels = feedRepository.findAll();
		List<String> tagNameList = new ArrayList<>();
		List<FeedResponseDto> responseDtoList = new ArrayList<>();

		for (FeedModel feedModel : feedModels) {
			List<Tag> tagList = tagRepository.findAllByFeedId(feedModel.getFeedId());

			for (Tag tag : tagList) {
				tagNameList.add(tagSetRepository.findByTagSetId(tag.getTagSetId()).getTagName());
			}

			MemberModel memberModel = memberRepository.findByIdOrElseThrow(feedModel.getMemberId());

			FeedResponseDto responseDto = new FeedResponseDto(feedModel.getFeedId(), memberModel.getNickname() , feedModel.getContent(), tagNameList);
			responseDtoList.add(responseDto);
			tagNameList.clear();
		}
		return responseDtoList;
	}

	//댓글조회 추가구현 필요
	@Override
	public FeedResponseDto getFeed(Long feedId,Long memberId) {
		memberRepository.findByIdOrElseThrow(memberId);

		FeedModel feedModel = feedRepository.findByIdOrElseThrow(feedId);
		List<Tag> tagList = tagRepository.findAllByFeedId(feedId);
		List<String> tagNameList = new ArrayList<>();

		for (Tag tag : tagList) {
			tagNameList.add(tagSetRepository.findByTagSetId(tag.getTagSetId()).getTagName());
		}
		MemberModel memberModel = memberRepository.findByIdOrElseThrow(feedModel.getMemberId());

		return new FeedResponseDto(feedModel.getFeedId(), memberModel.getNickname() ,feedModel.getContent(), tagNameList);
	}

	//한글 조회 안됨 이슈...
	@Override
	public List<FeedResponseDto> getSearchResultFeeds(String q, Long memberId) {
		memberRepository.findByIdOrElseThrow(memberId);
		List<FeedResponseDto> responseDtoList = new ArrayList<>();

		//tag로 조회
		TagSet tagSet = tagSetRepository.findByTagName(q).orElse(null);
		if(tagSet!=null){
			List<Tag> tagList =tagRepository.findAllByTagSetId(tagSet.getTagSetId());

			for(Tag tag : tagList){
				FeedModel feedModel = feedRepository.findByIdOrElseThrow(tag.getFeedId());
				MemberModel memberModel = memberRepository.findByIdOrElseThrow(feedModel.getMemberId());
				List<Tag> feedTagList = tagRepository.findAllByFeedId(feedModel.getFeedId());

				List<String> tagNameList = new ArrayList<>();

				for(Tag t : feedTagList){
					TagSet tSet = tagSetRepository.findByTagSetId(t.getTagSetId());
					tagNameList.add(tSet.getTagName());
				}
				responseDtoList.add(new FeedResponseDto(feedModel.getFeedId(),
					memberModel.getNickname() , feedModel.getContent(), tagNameList));
			}
		}

		//단어로 내용 content에서 조회
		List<FeedModel> allFeeds = feedRepository.findAll();
		for(FeedModel feedModel : allFeeds){
			if(feedModel.getContent().contains(q)){
				List<Tag> tagList = tagRepository.findAllByFeedId(feedModel.getFeedId());
				List<String> tagNameList = new ArrayList<>();
				for(Tag t : tagList){
					TagSet tSet = tagSetRepository.findByTagSetId(t.getTagSetId());
					tagNameList.add(tSet.getTagName());
				}
				responseDtoList.add(new FeedResponseDto(feedModel.getFeedId(),
					memberRepository.findByIdOrElseThrow(feedModel.getMemberId()).getNickname() , feedModel.getContent(), tagNameList));
			}
		}

		if(responseDtoList.isEmpty()){
			throw new CustomFeedException(FeedErrorCode.FEED_ERROR_CODE_SEARCH_NOT_FOUND);
		}
		return responseDtoList;
	}
}
