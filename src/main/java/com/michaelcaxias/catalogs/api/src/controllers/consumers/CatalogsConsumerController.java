package com.michaelcaxias.catalogs.api.src.controllers.consumers;

import com.michaelcaxias.catalogs.api.src.controllers.dto.CatalogDto;
import com.michaelcaxias.catalogs.api.src.domain.services.ConsumerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.michaelcaxias.catalogs.api.src.config.ResourceConfig.ROOT_PATH;

@RestController
@RequestMapping(ROOT_PATH)
@Validated
public class CatalogsConsumerController {
    @Autowired
    private ConsumerService<Integer> catalogsConsumerService;

    @PostMapping("/catalogs")
    public void save(final @RequestBody @Valid CatalogDto message) {
        catalogsConsumerService.process(message.ownerID());
    }

}
