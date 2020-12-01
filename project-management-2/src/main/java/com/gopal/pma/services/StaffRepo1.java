package com.gopal.pma.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

//@Primary // Spring injects this instance where there are multiple instances of StaffRepository
@Repository
public class StaffRepo1 implements StaffRepository{

}
