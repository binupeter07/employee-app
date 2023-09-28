import java.math.RoundingMode

val firstName = "Joe"
val surName = "Soap"
val gender = "M"
val employeeId = 6143
val grossSalary = 67543.21
val payePercentage = 38.5
val prsiPercentage = 5.2
val annualBonusAmount = 1450.50
val cycletoWorkSchemeMonthlyDeduction = 54.33

fun roundTwoDecimals(number: Double) = "%.2f".format(number).toDouble()

fun getFullName()= if (gender === "M" || gender==="m") {
    " Mr. $firstName $surName"
}else{
    "Mrs. $firstName $surName"
}

fun getMonthlySalary()= roundTwoDecimals(grossSalary/12)
fun getMonthlyPRSI()= roundTwoDecimals(getMonthlySalary() * (prsiPercentage/100))
fun getMonthlyPAYE() = roundTwoDecimals(getMonthlySalary() * (payePercentage/100))
fun getGrossMonthlyPay() = roundTwoDecimals(getMonthlySalary() + (annualBonusAmount / 12))
fun getTotalMonthlyDeductions() =roundTwoDecimals((getMonthlyPRSI() + getMonthlyPAYE() +cycletoWorkSchemeMonthlyDeduction) )
fun getNetMonthlyPay() = roundTwoDecimals(roundTwoDecimals(getGrossMonthlyPay() - getTotalMonthlyDeductions()))

fun getBonus() = roundTwoDecimals(annualBonusAmount/12)
fun getPayslip() =



    println("""    -------------------------------------------------------------------
    |                       Monthly Payslip                           |
    |-----------------------------------------------------------------|
    |   Employee Name:${getFullName()}       Employee Id:$employeeId            |
    |-----------------------------------------------------------------|
    |   PAYMENT DETAILS                   DEDUCTION DETAILS           |
    |-----------------------------------------------------------------|
    |   Salary:${getMonthlySalary()}                     PAYEE: ${getMonthlyPAYE()}              |
    |   Bonus: ${getBonus()}                     PRSI:${getMonthlyPRSI()}                 |
    |                                     Cycle To Work:$cycletoWorkSchemeMonthlyDeduction         |
    |-----------------------------------------------------------------|
    |   Gross:${getGrossMonthlyPay()}                     Total Deduction:${getTotalMonthlyDeductions()}     |
    |-----------------------------------------------------------------|
    |                    NET PAY: ${getNetMonthlyPay()}                             |
    -------------------------------------------------------------------""")


fun main(args: Array<String>) {
    println(getFullName())
    println(" Pay Slip Printer")
    println(getPayslip())
}