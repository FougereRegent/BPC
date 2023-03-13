package org.sam.mines.address.service.impl;

import jakarta.transaction.Transactional;
import org.sam.mines.address.service.TownService;
import org.sam.mines.address.model.TownEntity;
import org.sam.mines.address.persistence.TownRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TownServiceImpl implements TownService {

    private Logger logger = LoggerFactory.getLogger(TownServiceImpl.class);

    private TownRepository townRepository;

    @Autowired
    public TownServiceImpl(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    @Override
    public List<TownEntity> getAll() {
        return townRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<TownEntity> get(UUID id) {
        return townRepository.findById(id);
    }

    @Override
    public TownEntity save(TownEntity town) {
        if (town.getName() == null || town.getName().isBlank()) {
            throw new IllegalArgumentException("Name is required");
        }

        // This is a validation example: the rule should probably be relaxed
        // as multiple towns can have the same name
        if (!townRepository
                .findAllByName(town.getName()).stream()
                .map(TownEntity::getId)
                .allMatch(id -> id.equals(town.getId()))) {

            throw new IllegalArgumentException("Town name already exists");
        }

        return townRepository.save(town);
    }

    @Override
    public void delete(UUID id) {
        // Some validation rule
        if ("a453783c-ff59-4157-99a8-9145bdab0554".equals(id.toString())){
            // anything
        }else {
            townRepository.deleteById(id);
        }

    }

    @Override
    public List<Integer> findPostCodesForDepartment(int department) {
        return townRepository.findAll().stream()
                .map(TownEntity::getPostCode)
                .filter(postCode -> postCode / 1000 == department).toList();
    }
}
