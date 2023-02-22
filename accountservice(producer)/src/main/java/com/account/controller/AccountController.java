package com.account.controller;

import com.account.request.AccountDTO;
import com.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Quan Ly Tai Khoan
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public AccountDTO addAccount(@RequestBody AccountDTO accountDTO) {
        accountService.add(accountDTO);
        return accountDTO;
    }

    @GetMapping("/all")
    public List<AccountDTO> getAllAccount() {
        List<AccountDTO> listAccount = accountService.getAll();
        return listAccount;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> getById(@PathVariable(name = "id") Long id) {
        AccountDTO one = accountService.getOne(id);
        return Optional.of(new ResponseEntity(one, HttpStatus.OK)).orElse(new ResponseEntity<AccountDTO>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
         accountService.delete(id);
    }

}
