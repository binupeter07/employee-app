class Employee(var firstName:String, var surName:String, var gender:Char, var employeeID:Int,
                var grossSalary:Double, var payePercentage:Double, var prsiPercentage:Double,
                var annualBonus:Double,var cycleToWorkMonthlyDeduction:Double) {


    fun getFullName() = if (gender == 'm' || gender == 'M') {
        " Mr. ${firstName} ${surName}"
    } else {
        "Mrs. ${firstName} ${surName}"
    }

    fun getMonthlySalary() = roundTwoDecimals(grossSalary / 12)
    fun getMonthlyPRSI() = roundTwoDecimals(getMonthlySalary() * (prsiPercentage / 100))
    fun getMonthlyPAYE() = roundTwoDecimals(getMonthlySalary() * (payePercentage / 100))
    fun getGrossMonthlyPay() = roundTwoDecimals(getMonthlySalary() + (annualBonus / 12))
    fun getTotalMonthlyDeductions() =
        roundTwoDecimals((getMonthlyPRSI() + getMonthlyPAYE() + cycleToWorkMonthlyDeduction))

    fun getNetMonthlyPay() = roundTwoDecimals(roundTwoDecimals(getGrossMonthlyPay() - getTotalMonthlyDeductions()))

    fun getBonus() = roundTwoDecimals(annualBonus / 12)
    fun getPayslip() =


        println(
            """    -------------------------------------------------------------------
    |                       Monthly Payslip                           |
    |-----------------------------------------------------------------|
    |   Employee Name:${getFullName()}       Employee Id:${employeeID}          |
    |-----------------------------------------------------------------|
    |   PAYMENT DETAILS                   DEDUCTION DETAILS           |
    |-----------------------------------------------------------------|
    |   Salary:${getMonthlySalary()}                     PAYEE: ${getMonthlyPAYE()}              |
    |   Bonus: ${getBonus()}                     PRSI:${getMonthlyPRSI()}                 |
    |                                     Cycle To Work:${cycleToWorkMonthlyDeduction}         |
    |-----------------------------------------------------------------|
    |   Gross:${getGrossMonthlyPay()}                     Total Deduction:${getTotalMonthlyDeductions()}     |
    |-----------------------------------------------------------------|
    |                    NET PAY: ${getNetMonthlyPay()}                               |
    -------------------------------------------------------------------"""
        )

    override fun toString(): String {
        return "Employee(firstName='$firstName', surName='$surName', gender=$gender, employeeID=$employeeID, grossSalary=$grossSalary, payePercentage=$payePercentage, prsiPercentage=$prsiPercentage, annualBonus=$annualBonus, cycleToWorkMonthlyDeduction=$cycleToWorkMonthlyDeduction)"
    }

}