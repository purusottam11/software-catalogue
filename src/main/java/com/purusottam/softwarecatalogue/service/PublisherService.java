package com.purusottam.softwarecatalogue.service;

import com.purusottam.softwarecatalogue.bean.PublisherBean;

import java.util.List;

public interface PublisherService {

    PublisherBean addPublisher(PublisherBean publisherBean);

    PublisherBean updatePublisher(PublisherBean publisherBean,Long publisherId);

    List<PublisherBean> getAllPublisher();

    PublisherBean getPublisher(long publisherId);

}
