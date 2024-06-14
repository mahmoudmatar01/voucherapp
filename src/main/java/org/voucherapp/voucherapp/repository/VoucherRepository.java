package org.voucherapp.voucherapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.voucherapp.voucherapp.entity.Voucher;

import java.util.Optional;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher,Long> {
    Optional <Voucher> findByCode(String code);
}
