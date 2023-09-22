import java.math.RoundingMode

val firstName = "Joe"
val surName = "Soap"
val gender = "M"
val employeeId = 6143
val grossSalary = 67543.21f
val payePercentage = 38.5f
val prsiPercentage = 5.2f
val annualBonusAmount = 1450.50f
val cycletoWorkSchemeMonthlyDeduction = 54.33f

fun printingPayslip(){
    val monthlySalary = grossSalary/12
    val payee = payePercentage * monthlySalary/100
    val bonus = annualBonusAmount/12
    val prsi = monthlySalary*prsiPercentage/100

    val gross = grossSalary/12
    val monthlyDeduction = payee+prsi+cycletoWorkSchemeMonthlyDeduction
    val netpay = gross - monthlyDeduction

    println("-------------------------------------------------------------------")
    println("| \t \t \t \t \t \t  Monthly Payslip   \t \t \t \t \t  |" )
    println("|-----------------------------------------------------------------|")
    println("|\tEmployee Name:${firstName.uppercase()} ${surName.uppercase()}($gender) \t \t Employee Id:$employeeId\t \t \t  |")
    println("|-----------------------------------------------------------------|")
    println("|\tPAYMENT DETAILS \t \t \t \t DEDUCTION DETAILS \t \t \t  |")
    println("|-----------------------------------------------------------------|")
    println("|\tSalary:%.2f".format(monthlySalary) +"\t \t \t \t \t PAYEE: %.2f".format(payee) +"\t \t \t \t  |")
    println("|\tBonus: %.2f".format(bonus)+"\t \t \t \t \t PRSI:%.2f".format(prsi) +" \t \t \t \t  |")
    println("| \t \t \t \t \t \t \t \t  \t Cycle To Work:$cycletoWorkSchemeMonthlyDeduction \t \t  |")
    println("|-----------------------------------------------------------------|")
    println("|\tGross:%.2f".format(gross)+"\t \t \t \t \t Total Deduction:%.2f".format(monthlyDeduction)+" \t  |")
    println("|-----------------------------------------------------------------|")
    println("|\t \t \t \t \t \tNET PAY: %.2f".format(netpay) +"\t \t \t \t \t \t  |")
    println("-------------------------------------------------------------------")
}

fun main(args: Array<String>) {
    println("Pay Slip Printer")
    printingPayslip()
}