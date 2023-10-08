package ie.setu

import controllers.EmployeeAPI
import models.Employee
import mu.KotlinLogging


//RoundTwoDecimal Method
fun roundTwoDecimals(number: Double) = "%.2f".format(number).toDouble()

var employees = EmployeeAPI()


//Gradle logging
val logger = KotlinLogging.logger {}

fun main(args: Array<String>){
    logger.info { "Launching Employee App" }
    logger.info { "Welcome to Employee App" }
    logger.info { "Great to see you again" }
    logger.info{ "You can find the employee details here" }

    start()
}


fun menu(): Int{
    print(""" 
         |Employee Menu
         |   1. Add Employee
         |   2. List All Employees
         |   3. Search Employees 
         |   4. Print Payslip for Employee
         |   5. Remove Employee
         |   6. Sort Employee by Name
         |   7. Update Employee
         |  -1. Exit
         |       
         |Enter Option : """.trimMargin())
    return readLine()!!.toInt()
}

//Start function
fun start() {
    var input: Int

    do {
        input = menu()
        when (input) {
            1 -> add()
            2 -> list()
            3 -> search()
            4 -> paySlip()
            5 -> remove()
            6 -> sortBy()
            7 -> updateEmployee()
            -99 -> dummyData()
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
}

//List Function
fun list(){
    println(
        employees.findAll()
        .forEach{ println(it)})
}

// Source of sortBy method i learned
// https://www.youtube.com/watch?v=IUYoJSgaHQE
fun sortBy(){
    println(employees.sortByName()
        .forEach{ println(it) })

}


//Search Method
fun search() {
    val employee = getEmployeeById()
    if (employee == null)
        println("No employee found")
    else
        println(employee)
}


//Remove Method
fun remove(){

    list()
    val employee = getEmployeeById()
    if(employee == null)
        println("No employee found")
    else {
        employees.delete(employee)
        println("Successfully Deleted")
    }
}

//Update Method
fun updateEmployee(){
    println("Enter the id of Employee")
    val employeeID = readLine()!!.toInt()
    println("What you should want to update")

    print(""" 
         |Employee Menu
         |   1. Change First Name
         |   2. Change Second Name
         |   3. Change Gross Salary
         |   4. Change Paye Percentage
         |   5. Change PRSI Percentage
         |       
         |Enter Option : """.trimMargin())
         val change = readLine()!!.toInt()


    when (change) {
        1 -> println("Enter the first name")
        2 -> println("Enter the second name")
        3 -> println("Enter the gross salary")
        4 -> println("Enter the PAYE Percentage")
        5 -> println("Enter the PRSI Percentage")
        else -> println("Invalid Option")
    }
    val updateData = readLine()!!
    println()

        employees.updated(employeeID,change,updateData)


}
// Find employee by ID method
internal fun getEmployeeById(): Employee? {
    print("Enter the employee id to search by: ")
    val employeeID = readLine()!!.toInt()
    return employees.findOne(employeeID)
}


// Printing payslip method
fun paySlip(){
    list()
    val employee = getEmployeeById()
    if (employee != null)
        println(employee.getPayslip())
}

fun dummyData() {
    employees.create(Employee("Joe", "Soap", 'm', 0, 35655.43, 31.0, 7.5, 2000.0, 25.6))
    employees.create(Employee("Binu", "Murphy", 'f', 0, 54255.13, 32.5, 7.0, 1500.0, 55.3))
    employees.create(Employee("Mary", "Quinn", 'f', 0, 75685.41, 40.0, 8.5, 4500.0, 0.0))
}


//Add method
fun add(){
    print("Enter first name: ")
    val firstName = readLine().toString()
    print("Enter surname: ")
    val surname = readLine().toString()
    print("Enter gender (m/f): ")
    val gender = readLine()!!.toCharArray()[0]
    print("Enter gross salary: ")
    val grossSalary = readLine()!!.toDouble()
    print("Enter PAYE %: ")
    val payePercentage = readLine()!!.toDouble()
    print("Enter PRSI %: ")
    val prsiPercentage = readLine()!!.toDouble()
    print("Enter Annual Bonus: ")
    val annualBonus= readLine()!!.toDouble()
    print("Enter Cycle to Work Deduction: ")
    val cycleToWorkMonthlyDeduction= readLine()!!.toDouble()

    employees.create(Employee(firstName, surname, gender, 0, grossSalary, payePercentage, prsiPercentage, annualBonus, cycleToWorkMonthlyDeduction))
}




