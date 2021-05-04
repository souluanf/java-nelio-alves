package model.services;

import model.entities.Contract;
import model.entities.Installment;

import java.util.Calendar;
import java.util.Date;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, int months) {
        double basicQuota = contract.getTotalValue() / months;
        // basicQuota = 200.0
        for (int mes = 1; mes <= months; mes++) {
            double updatedQuota = basicQuota + onlinePaymentService.interest(basicQuota, mes);
            // updatedQuota = 202.0
            double fullQuota = updatedQuota + onlinePaymentService.paymentFee(updatedQuota);
            // fullQuota = 206.04

            Date dueDate = addMonths(contract.getDate(), mes);
            contract.getInstallments().add(new Installment(dueDate, fullQuota));

        }
    }

    private Date addMonths(Date date, int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.add(Calendar.MONTH, n);

        return calendar.getTime();
    }
}
