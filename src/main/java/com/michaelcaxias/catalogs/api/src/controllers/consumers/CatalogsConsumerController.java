package com.michaelcaxias.catalogs.api.src.controllers.consumers;

import com.michaelcaxias.catalogs.api.src.controllers.dto.CatalogDto;
import jakarta.validation.Valid;
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

    @PostMapping("/catalogs")
    public void save(final @RequestBody @Valid CatalogDto CatalogDto) {

    }

}
