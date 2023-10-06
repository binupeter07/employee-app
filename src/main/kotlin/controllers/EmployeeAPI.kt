package controllers

import ie.setu.*
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
        employees.remove(employee)
    }

    fun updated (id: Int,input:Int,data:Any){
        val employee = findOne(id)
        if(employee == null)
            println("No employee found")
        else {
            when (input) {
                1 -> employee.firstName = data.toString()
                2 -> employee.surName = data.toString()
                3 -> employee.grossSalary = data.toString().toDoubleOrNull()!!
                4 -> employee.payePercentage = data.toString().toDoubleOrNull()!!
                5 -> employee.prsiPercentage = data.toString().toDoubleOrNull()!!
            }
            println()
        }

    }



}




