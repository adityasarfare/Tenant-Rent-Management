package com.springRest.tenantRent.service;

import com.springRest.tenantRent.entity.RentPayment;
import java.util.Collections;
import com.springRest.tenantRent.repository.RentPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class RentPaymentService {

    private final RentPaymentRepository rentPaymentRepository;

    @Autowired
    public RentPaymentService(RentPaymentRepository rentPaymentRepository) {
        this.rentPaymentRepository = rentPaymentRepository;
    }

    // Fetch all rent payments page wise
    public Page<RentPayment> getAllRentPayments(Pageable pageable) {
        return rentPaymentRepository.findAll(pageable);
    }

    // Fetch rent payment by ID
    public RentPayment getRentPaymentById(Integer id) {
        return rentPaymentRepository.findById(Long.valueOf(id)).orElse(null);
    }

    // Create or update a rent payment
    public RentPayment saveRentPayment(RentPayment rentPayment) {
        return rentPaymentRepository.save(rentPayment);
    }

    // Delete a rent payment by ID
    public void deleteRentPayment(Integer id) {
        rentPaymentRepository.deleteById(Long.valueOf(id));
    }
    
    // Fetch all rent payments by tenant ID
    public List<RentPayment> getRentPaymentsByTenantId(Integer tenantId) {
        Optional<RentPayment> rentPayment = rentPaymentRepository.findById(Long.valueOf(tenantId));
        return rentPayment.map(Collections::singletonList)
                          .orElse(Collections.emptyList());
    }
}
