package com.purusottam.softwarecatalogue.impl;

import com.purusottam.softwarecatalogue.bean.PublisherBean;
import com.purusottam.softwarecatalogue.exception.BusinessException;
import com.purusottam.softwarecatalogue.exception.ErrorCode;
import com.purusottam.softwarecatalogue.model.Publisher;
import com.purusottam.softwarecatalogue.repository.PublisherRepository;
import com.purusottam.softwarecatalogue.service.PublisherService;
import com.purusottam.softwarecatalogue.utils.XoriskUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;

    @Override
    public PublisherBean addPublisher(PublisherBean publisherBean) {
        publisherRepository.findByName(publisherBean.getName()).ifPresent(
                i -> {
                    throw new BusinessException(ErrorCode.PUBLISHER_IS_EXIST.getMessage());
                }
        );
        Publisher publisher = new Publisher();
        XoriskUtils.copySafe(publisherBean, publisher);
        XoriskUtils.copySafe(publisherRepository.save(publisher), publisherBean);
        return publisherBean;
    }

    @Override
    public PublisherBean updatePublisher(PublisherBean publisherBean) {
        Publisher publisher = publisherRepository.findById(publisherBean.getId())
                .orElseThrow(() -> new BusinessException(ErrorCode.PUBLISHER_NOT_FOUND.getMessage()));
        XoriskUtils.copySafe(publisherBean, publisher);
        publisher = publisherRepository.save(publisher);
        XoriskUtils.copySafe(publisher, publisherBean);
        return publisherBean;
    }

    @Override
    public List<PublisherBean> getAllPublisher() {
        List<Publisher> publishers = publisherRepository.findAll();
        List<PublisherBean> publisherBeans = XoriskUtils.copySafe(publishers, PublisherBean.class);
        return publisherBeans;
    }

    @Override
    public PublisherBean getPublisher(long publisherId) {
        Publisher publisher = publisherRepository.findById(publisherId).orElseThrow(
                () -> new BusinessException(ErrorCode.PUBLISHER_NOT_FOUND));
        PublisherBean publisherBean = new PublisherBean();
        XoriskUtils.copySafe(publisherRepository.getOne(publisherId), publisherBean);
        return publisherBean;
    }
}
