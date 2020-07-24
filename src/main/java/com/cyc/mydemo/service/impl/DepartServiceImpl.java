package com.cyc.mydemo.service.impl;

import com.cyc.mydemo.repository.DepartRepository;
import com.cyc.mydemo.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartServiceImpl implements DepartService {
    @Autowired
    private DepartRepository departRepository;
}
