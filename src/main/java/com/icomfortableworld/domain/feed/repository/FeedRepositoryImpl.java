package com.icomfortableworld.domain.feed.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.icomfortableworld.domain.feed.entity.Feed;
import com.icomfortableworld.domain.feed.model.FeedModel;
import com.icomfortableworld.global.exception.feed.CustomFeedException;
import com.icomfortableworld.global.exception.feed.FeedErrorCode;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class FeedRepositoryImpl implements FeedRepository {
	private final FeedJpaRepository feedJpaRepository;

	@Override
	public Feed save(Feed feed) {
		return feedJpaRepository.save(feed);
	}

	@Override
	public FeedModel findByIdOrElseThrow(Long feedId) {
		return findById(feedId).orElseThrow(
			() -> new CustomFeedException(FeedErrorCode.FEED_ERROR_CODE_NOT_FOUND)
		);
	}

	@Override
	public Optional<FeedModel> findById(Long feedId) {
		return feedJpaRepository.findById(feedId).map(Feed::toModel);
	}

	@Override
	public FeedModel update(Long feedId, Long memberId, String content, String authority) {
		Feed feed = feedJpaRepository.findById(feedId).orElseThrow(
			() -> new CustomFeedException(FeedErrorCode.FEED_ERROR_CODE_NOT_FOUND)
		);
		if (!feed.getMemberId().equals(memberId) && !authority.equals("ROLE_ADMIN")) {
			throw new CustomFeedException(FeedErrorCode.FEED_ERROR_CODE_ID_MISMATCH);
		}
		feed.update(content);
		return feed.toModel();
	}

	@Override
	public List<FeedModel> findAll() {
		return feedJpaRepository.findAll().stream().map(Feed::toModel).toList();
	}

	@Override
	public List<FeedModel> findAllById(Long feedId) {
		return feedJpaRepository.findById(feedId).stream().map(Feed::toModel).toList();
	}

	@Override
	public void deleteById(Long feedId, Long memberId, String authority) {
		Feed feed = feedJpaRepository.findById(feedId).orElseThrow(
			() -> new CustomFeedException(FeedErrorCode.FEED_ERROR_CODE_NOT_FOUND)
		);
		if (!feed.getMemberId().equals(memberId) && !authority.equals("ROLE_ADMIN")) {
			throw new CustomFeedException(FeedErrorCode.FEED_ERROR_CODE_ID_MISMATCH);
		}
		feedJpaRepository.deleteById(feedId);
	}

}
