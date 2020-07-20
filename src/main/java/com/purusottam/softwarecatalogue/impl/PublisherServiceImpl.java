package com.purusottam.softwarecatalogue.impl;

import com.purusottam.softwarecatalogue.bean.PublisherBean;
import com.purusottam.softwarecatalogue.esmodel.PublisherEs;
import com.purusottam.softwarecatalogue.esrepo.PublisherEsRepository;
import com.purusottam.softwarecatalogue.exception.BusinessException;
import com.purusottam.softwarecatalogue.exception.ErrorCode;
import com.purusottam.softwarecatalogue.model.Publisher;
import com.purusottam.softwarecatalogue.repository.PublisherRepository;
import com.purusottam.softwarecatalogue.service.PublisherService;
import com.purusottam.softwarecatalogue.utils.XoriskUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;
    private final PublisherEsRepository publisherEsRepository;

    @Transactional
    @Override
    public PublisherBean addPublisher(PublisherBean publisherBean) {
        publisherRepository.findByName(publisherBean.getName()).ifPresent(
                i -> {
                    throw new BusinessException(ErrorCode.PUBLISHER_IS_EXIST.getMessage());
                }
        );
        Publisher publisher = new Publisher();
        PublisherEs publisherEs = new PublisherEs();
        XoriskUtils.copySafe(publisherBean, publisher);
        XoriskUtils.copySafe(publisherRepository.save(publisher), publisherEs);
        publisherEsRepository.save(publisherEs);
        XoriskUtils.copySafe(publisherEs, publisherBean);
        return publisherBean;
    }

    @Transactional
    @Override
    public PublisherBean updatePublisher(PublisherBean publisherBean, Long publisherId) {
        Publisher publisher = publisherRepository.findById(publisherId)
                .orElseThrow(() -> new BusinessException(ErrorCode.PUBLISHER_NOT_FOUND.getMessage()));
        PublisherEs publisherEs = publisherEsRepository.findById(publisherId)
                .orElseThrow(() -> new BusinessException(ErrorCode.PUBLISHER_NOT_FOUND.getMessage()));

        XoriskUtils.copySafe(publisherBean, publisher);
        publisher.setId(publisherId);
        publisher = publisherRepository.save(publisher);

        XoriskUtils.copySafe(publisherBean, publisherEs);
        publisherEs.setId(publisherId);
        publisherEs = publisherEsRepository.save(publisherEs);
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
