package com.globallogic.task.service;

import com.globallogic.task.model.Office;
import com.globallogic.task.repository.OfficeRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public final class DataGenerator {

    private final OfficeRepository officeRepository;

    public DataGenerator(final OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    @PostConstruct
    public void saveOffices() {
        officeRepository.saveAll(createOffices());
    }

    private List<Office> createOffices() {
        return IntStream.range(1, 10).mapToObj(i -> new Office(String.join("", "Name-", String.valueOf(i)))).collect(Collectors.toList());
    }

}
