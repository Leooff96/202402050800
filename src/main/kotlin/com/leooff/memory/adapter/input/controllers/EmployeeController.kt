package com.leooff.memory.adapter.input.controllers

import com.leooff.memory.adapter.data.entities.Employee
import com.leooff.memory.adapter.data.entities.EmployeeRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class EmployeeController(private val employeeRepository: EmployeeRepository){

    @GetMapping("/employees")
    fun findAllEmployees(): Iterable<Employee> {
        return employeeRepository.findAll()
    }

    @PostMapping("/employees")
    fun addOneEmployee(@RequestBody employee: Employee): Employee {
        return employeeRepository.save(employee)
    }
}