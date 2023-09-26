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



fun printingPayslip(){
    val monthlySalary = grossSalary/12
    val payee = payePercentage * monthlySalary/100
    val bonus = annualBonusAmount/12
    val prsi = monthlySalary*prsiPercentage/100

    val gross = grossSalary/12
    val monthlyDeduction = payee+prsi+cycletoWorkSchemeMonthlyDeduction
    val netpay = gross - monthlyDeduction

    println("""    -------------------------------------------------------------------
    |                       Monthly Payslip                           |
    |-----------------------------------------------------------------|
    |   Employee Name:${firstName.uppercase()} ${surName.uppercase()}($gender)         Employee Id:$employeeId            |
    |-----------------------------------------------------------------|
    |   PAYMENT DETAILS                   DEDUCTION DETAILS           |
    |-----------------------------------------------------------------|
    |   Salary:${roundTwoDecimals(monthlySalary)}                     PAYEE: ${roundTwoDecimals(payee)}              |
    |   Bonus: ${roundTwoDecimals(bonus)}                     PRSI:${roundTwoDecimals(prsi)}                 |
    |                                     Cycle To Work:$cycletoWorkSchemeMonthlyDeduction         |
    |-----------------------------------------------------------------|
    |  Gross:${roundTwoDecimals(gross)}                   Total Deduction:${roundTwoDecimals(monthlyDeduction)}         |
    |-----------------------------------------------------------------|
    |                  NET PAY: ${roundTwoDecimals(netpay)}                               |
    -------------------------------------------------------------------""")
}

fun main(args: Array<String>) {
    println("Pay Slip Printer")
    printingPayslip()
}