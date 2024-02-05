package com.leooff.memory.adapter.data.entities

import org.springframework.data.repository.CrudRepository

interface EmployeeRepository : CrudRepository<Employee,Int> {
}