package controllers

import ie.setu.getEmployeeById
import models.Employee

var lastId = 0

    internal fun getId(): Int {
        return lastId++
    }



class EmployeeAPI {

    private val employees = ArrayList<Employee>()

    fun findAll(): List<Employee> {
        return employees
    }

    fun sortByName(): List<Employee> {
        val employees = findAll()
        val sortedEmployees = employees.sortedBy { it.firstName }
        return sortedEmployees
    }

    fun findOne(id: Int): Employee? {
        return employees.find { p -> p.employeeID == id }
    }

        fun create(employee: Employee) {
            employee.employeeID = getId()
            employees.add(employee)
        }

    fun delete(employee: Employee){
        employee.employeeID = getId()
        employees.remove(employee)
    }




}




