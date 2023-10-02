import java.math.RoundingMode


 var employee = Employee("Joe","Soap", 'm',6143,67543.21,38.5,5.2,1450.50,54.3)
fun roundTwoDecimals(number: Double) = "%.2f".format(number).toDouble()

fun getFullName()= if (employee.gender == 'm' || employee.gender =='M') {
    " Mr. ${employee.firstName} ${employee.surName}"
}else{
    "Mrs. ${employee.firstName} ${employee.surName}"
}

fun getMonthlySalary()= roundTwoDecimals(employee.grossSalary/12)
fun getMonthlyPRSI()= roundTwoDecimals(getMonthlySalary() * (employee.prsiPercentage/100))
fun getMonthlyPAYE() = roundTwoDecimals(getMonthlySalary() * (employee.payePercentage/100))
fun getGrossMonthlyPay() = roundTwoDecimals(getMonthlySalary() + (employee.annualBonus / 12))
fun getTotalMonthlyDeductions() =roundTwoDecimals((getMonthlyPRSI() + getMonthlyPAYE() +employee.cycleToWorkMonthlyDeduction) )
fun getNetMonthlyPay() = roundTwoDecimals(roundTwoDecimals(getGrossMonthlyPay() - getTotalMonthlyDeductions()))

fun getBonus() = roundTwoDecimals(employee.annualBonus/12)
fun getPayslip() =



    println("""    -------------------------------------------------------------------
    |                       Monthly Payslip                           |
    |-----------------------------------------------------------------|
    |   Employee Name:${getFullName()}       Employee Id:${employee.employeeID}          |
    |-----------------------------------------------------------------|
    |   PAYMENT DETAILS                   DEDUCTION DETAILS           |
    |-----------------------------------------------------------------|
    |   Salary:${getMonthlySalary()}                     PAYEE: ${getMonthlyPAYE()}              |
    |   Bonus: ${getBonus()}                     PRSI:${getMonthlyPRSI()}                 |
    |                                     Cycle To Work:${employee.cycleToWorkMonthlyDeduction}         |
    |-----------------------------------------------------------------|
    |   Gross:${getGrossMonthlyPay()}                     Total Deduction:${getTotalMonthlyDeductions()}     |
    |-----------------------------------------------------------------|
    |                    NET PAY: ${getNetMonthlyPay()}                               |
    -------------------------------------------------------------------""")


fun menu(): Int{
    print("""
        Employee Menu for ${getFullName()}
            1. Monthly Salary
            2. Monthly PRSI
            3. Monthly PAYE
            4. Monthly Gross Pay
            5. Monthly Total Deduction
            6. Monthly Net Pay
            7. Full Payslip
            -1.Exit
             Enter Option : """
    )
    return readLine()!!.toInt()

}

fun add(){
    print("Enter first name: ")
    val firstName = readLine().toString()
    print("Enter surname: ")
    val surname = readLine().toString()
    print("Enter gender (m/f): ")
    val gender = readLine()!!.toCharArray()[0]
    print("Enter employee ID: ")
    val employeeID = readLine()!!.toInt()
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

    employee = Employee(firstName, surname, gender, employeeID, grossSalary, payePercentage, prsiPercentage, annualBonus, cycleToWorkMonthlyDeduction)
}


fun main(args: Array<String>) {
    add()
    var input :Int
    do {
        input = menu()
        when(input){
            1 -> println("Monthly Salary: ${getMonthlySalary()}")
            2 -> println("Monthly PRSI: ${getMonthlyPRSI()}")
            3 -> println("Monthly PAYE: ${getMonthlyPAYE()}")
            4 -> println("Monthly Gross Pay: ${getGrossMonthlyPay()}")
            5 -> println("Monthly Total Deductions: ${getTotalMonthlyDeductions()}")
            6 -> println("Monthly Net Pay: ${getNetMonthlyPay()}")
            7 -> println(getPayslip())
            -1 -> println("Exiting App")
            else -> println("Invalid Option")

        }
        println()
    }while (input != -1)
}

