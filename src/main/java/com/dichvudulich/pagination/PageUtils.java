package com.dichvudulich.pagination;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

public class PageUtils {
	public static <T> Page<T> addIndexToPage(Page<T> page, int currentPage, int pageSize) {
		List<T> content = page.getContent();
		int startIndex = (int) page.getPageable().getOffset() + 1;

		int totalPages = (int) Math.ceil((double) page.getTotalElements() / pageSize);
		int currentPageIndex = currentPage + 1;
		int endIndex = Math.min(startIndex + content.size() - 1, currentPageIndex * pageSize);

		return new PageImpl<>(content, page.getPageable(), page.getTotalElements());
	}
}
