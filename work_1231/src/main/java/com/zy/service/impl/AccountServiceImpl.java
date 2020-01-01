package com.zy.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zy.dao.AccountMapper;
import com.zy.model.Account;
import com.zy.model.AccountExample;
import com.zy.service.AccountService;
/**
  *@author zy
  *@Date 2020-01-01 22:18
  */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService{

}
