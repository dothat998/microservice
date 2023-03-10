package com.account.service.impl;

import com.account.entity.AccountEntity;
import com.account.repository.AccountRepository;
import com.account.request.AccountDTO;
import com.account.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void add(AccountDTO accountDTO) {
        AccountEntity accountEntity = modelMapper.map(accountDTO, AccountEntity.class);
//        accountEntity.setPassword(new BCryptPasswordEncoder().encode(accountDTO.getPassword()));
        accountRepository.save(accountEntity);
        accountDTO.setId(accountEntity.getId());
    }

    @Override
    public void update(AccountDTO accountDTO) {
        AccountEntity account = accountRepository.getById(accountDTO.getId());
//        if (account != null){
//            modelMapper.typeMap(AccountDTO.class,AccountEntity.class)
//                    .addMapping(mapperDto -> mapperDto.skip(AccountEntity:: setPassword)).map(accountDTO, account);
//            accountRepository.save(account);
//        }

    }

    @Override
    public void updatePassword(AccountDTO accountDTO) {
        AccountEntity account = accountRepository.getById(accountDTO.getId());
        if (account != null){
            //        accountEntity.setPassword(new BCryptPasswordEncoder().encode(accountDTO.getPassword()));
            accountRepository.save(account);
        }
    }

    @Override
    public void delete(Long id) {
        AccountEntity account = accountRepository.getById(id);
        if (account != null){
            accountRepository.delete(account);
        }

    }

    @Override
    public List<AccountDTO> getAll() {
        List<AccountDTO> accountDTOS = new ArrayList<>();
        accountRepository.findAll().forEach((accountEntity -> {
            accountDTOS.add(modelMapper.map(accountEntity,AccountDTO.class));
        }));
        return accountDTOS;
    }

    @Override
    public AccountDTO getOne(Long id) {
        AccountEntity account = accountRepository.getById(id);
        if (account != null){
            return modelMapper.map(account, AccountDTO.class);
        }
        return null;
    }
}
