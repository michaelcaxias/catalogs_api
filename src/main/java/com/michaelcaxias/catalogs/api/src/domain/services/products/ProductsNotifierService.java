package com.michaelcaxias.catalogs.api.src.domain.services.products;

import com.michaelcaxias.catalogs.api.src.repositories.aws.sns.SNSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.model.Topic;

@Service
public class ProductsNotifierService {
    @Autowired
    private SNSService snsService;

    @Autowired
    @Qualifier("catalogEmitTopic")
    private Topic topic;

    public void notify(final Integer ownerID) {
        final String message = String.valueOf(ownerID);

        snsService.publish(topic, message);
    }
}
