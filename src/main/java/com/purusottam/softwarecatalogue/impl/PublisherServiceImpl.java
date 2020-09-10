package com.purusottam.softwarecatalogue.impl;

import com.purusottam.softwarecatalogue.bean.PublisherBean;
import com.purusottam.softwarecatalogue.esmodel.PublisherEs;
import com.purusottam.softwarecatalogue.esrepo.PublisherEsRepository;
import com.purusottam.softwarecatalogue.exception.BusinessException;
import com.purusottam.softwarecatalogue.exception.ErrorCode;
import com.purusottam.softwarecatalogue.model.Publisher;
import com.purusottam.softwarecatalogue.repository.PublisherRepository;
import com.purusottam.softwarecatalogue.service.PublisherService;
import com.purusottam.softwarecatalogue.utils.CopyUtils;
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
        CopyUtils.copySafe(publisherBean, publisher);
        CopyUtils.copySafe(publisherRepository.save(publisher), publisherEs);
        publisherEsRepository.save(publisherEs);
        CopyUtils.copySafe(publisherEs, publisherBean);
        return publisherBean;
    }

    @Transactional
    @Override
    public PublisherBean updatePublisher(PublisherBean publisherBean, Long publisherId) {
        Publisher publisher = publisherRepository.findById(publisherId)
                .orElseThrow(() -> new BusinessException(ErrorCode.PUBLISHER_NOT_FOUND.getMessage()));
        PublisherEs publisherEs = publisherEsRepository.findById(publisherId)
                .orElseThrow(() -> new BusinessException(ErrorCode.PUBLISHER_NOT_FOUND.getMessage()));

        CopyUtils.copySafe(publisherBean, publisher);
        publisher.setId(publisherId);
        publisher = publisherRepository.save(publisher);

        CopyUtils.copySafe(publisherBean, publisherEs);
        publisherEs.setId(publisherId);
        publisherEs = publisherEsRepository.save(publisherEs);
        CopyUtils.copySafe(publisher, publisherBean);
        return publisherBean;
    }

    @Override
    public List<PublisherBean> getAllPublisher() {
        List<Publisher> publishers = publisherRepository.findAll();
        List<PublisherBean> publisherBeans = CopyUtils.copySafe(publishers, PublisherBean.class);
        return publisherBeans;
    }

    @Override
    public PublisherBean getPublisher(long publisherId) {
        Publisher publisher = publisherRepository.findById(publisherId).orElseThrow(
                () -> new BusinessException(ErrorCode.PUBLISHER_NOT_FOUND));
        PublisherBean publisherBean = new PublisherBean();
        CopyUtils.copySafe(publisherRepository.getOne(publisherId), publisherBean);
        return publisherBean;
    }

    @Override
    @Transactional
    public String deletePublisher(Long publisherId) {
        Publisher publisher = publisherRepository.findById(publisherId).orElseThrow(
                () -> new BusinessException(ErrorCode.PUBLISHER_NOT_FOUND.getMessage()));
        //FIXME me must to delete all the Product which Publisher is deleted
        publisherRepository.deleteById(publisherId);
        publisherEsRepository.deleteById(publisherId);
        return "success";
    }
}
