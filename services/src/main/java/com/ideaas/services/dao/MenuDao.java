package com.ideaas.services.dao;

import com.ideaas.services.domain.Menu;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MenuDao extends PagingAndSortingRepository<Menu, Long> {
}
