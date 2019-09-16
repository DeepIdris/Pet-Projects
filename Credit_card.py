'''
Program to compute credit card debt terms
'''

def monthly_credit_card_balance(balance, annualInterestRate, monthlyPaymentRate):
    '''
    Function to calculate the credit card balance after one year if a person only pays the minimum monthly payment
    required by the credit card company each month.

    balance= the outstanding balance on the credit card

    annualInterestRate - annual interest rate as a decimal

    monthlyPaymentRate - minimum monthly payment rate as a decimal
    '''

    total_paid = 0
    for m in range(1, 13):
        minimum_monthly_payment = balance * monthlyPaymentRate
        total_paid +=  minimum_monthly_payment
        unpaid_balance = balance - minimum_monthly_payment
        interest = annualInterestRate/12 * unpaid_balance
        balance = unpaid_balance + interest
        print ('Month: ', m)
        print ('Minimum monthly payment: ', minimum_monthly_payment)
        print ('Remaining balance: ', balance)
        print ('---------------------------------------')
    print ('Total paid for the year: ', round(total_paid, 2))
    print ('Remaining balance at end of the year: ', round(balance, 2))

def generate_fixed_monthly_pay(balance_n, annualInterestRate):
    '''
    Function to calculate the minimum fixed monthly payment needed in order pay off
    a credit card balance within 12 months.

    balance- the outstanding balance on the credit card

    annualInterestRate - annual interest rate as a decimal
    '''

    minimum_fixed_monthly_payment = 0
    while True:
        minimum_fixed_monthly_payment += 10
        unpaid_balance, interest = 0, 0
        balance = balance_n
        for m in range(1, 13):
            unpaid_balance = balance - minimum_fixed_monthly_payment
            interest = annualInterestRate / 12 * unpaid_balance
            balance = unpaid_balance + interest

        if balance <= 0:
            print ('Lowest Payment: ', minimum_fixed_monthly_payment)
            print ('Balance left: ', balance)
            break
        else:
            continue


def fixed_monthly_payment_with_bisection_search(balance_n, annualInterestRate):
    '''
     Function to calculates the minimum fixed monthly payment needed in order pay off
      a credit card balance within 12 months using bisection search.

     balance= the outstanding balance on the credit card

     annualInterestRate - annual interest rate as a decimal
     '''

    monthly_interest_rate = annualInterestRate / 12
    monthly_payment_lower_bound = balance_n / 12
    monthly_payment_upper_bound = (balance_n * (1 + monthly_interest_rate) ** 12) / 12.0
    minimum_fixed_monthly_payment = (monthly_payment_lower_bound + monthly_payment_upper_bound) / 2
    previous_minimum, previous_balance = 0.0, 0.0

    while True:
        unpaid_balance, interest = 0, 0
        balance = balance_n
        for m in range(1, 13):
            unpaid_balance = balance - minimum_fixed_monthly_payment
            interest = annualInterestRate / 12 * unpaid_balance
            balance = unpaid_balance + interest

        if balance <= 0:
            previous_minimum = minimum_fixed_monthly_payment
            previous_balance = balance
            monthly_payment_upper_bound = minimum_fixed_monthly_payment
            minimum_fixed_monthly_payment = (monthly_payment_lower_bound + minimum_fixed_monthly_payment) / 2
            continue

        else:
            minimum_fixed_monthly_payment = previous_minimum
            print ('Lowest Payment: ', minimum_fixed_monthly_payment)
            print ('Balance left: ', previous_balance)
            break


# fixed_monthly_payment_with_bisection_search(999999, 0.18)


# generate_fixed_monthly_pay(320000, 0.2)

# monthly_credit_card_balance(5000, 0.18, 0.02)

