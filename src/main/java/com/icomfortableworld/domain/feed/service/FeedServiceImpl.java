package com.icomfortableworld.domain.feed.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icomfortableworld.domain.feed.dto.FeedRequestDto;
import com.icomfortableworld.domain.feed.entity.Feed;
import com.icomfortableworld.domain.feed.model.FeedModel;
import com.icomfortableworld.domain.tag.entity.Tag;
import com.icomfortableworld.domain.tag.entity.TagSet;
import com.icomfortableworld.domain.feed.repository.FeedRepository;
import com.icomfortableworld.domain.member.entity.Member;
import com.icomfortableworld.domain.member.repository.MemberRepository;
import com.icomfortableworld.domain.tag.repository.TagRepository;
import com.icomfortableworld.domain.tag.repository.TagSetRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class FeedServiceImpl implements FeedService{

	private final FeedRepository feedRepository;
	private final MemberRepository memberRepository;
	private final TagRepository tagRepository;
	private final TagSetRepository tagSetRepository;


	//유저 존재 확인
	//태그 같이 생성
	@Override
	public void createFeed(FeedRequestDto requestDto, Long memberId) {
		memberRepository.findByIdOrElseThrow(memberId);
		FeedModel feedModel = feedRepository.save(new Feed(requestDto, memberId)).toModel();

		for(String tagName : requestDto.getTagNameList()){
			//없으면 만들어주기~
			TagSet tagSet = tagSetRepository.findByTagName(tagName).orElse(null);
			if(tagSet==null){
				tagSet = tagSetRepository.save(new TagSet(tagName));
			}
			Tag tag = new Tag(feedModel.getFeedId(), tagSet.getTagSetId());
			tagRepository.save(tag);
		}
	}
}
