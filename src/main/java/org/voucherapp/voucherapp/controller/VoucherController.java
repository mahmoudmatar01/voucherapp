package org.voucherapp.voucherapp.controller;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.voucherapp.voucherapp.repository.VoucherRepository;
import org.voucherapp.voucherapp.entity.Voucher;
@RestController
@RequestMapping("/api/voucher")
public class VoucherController {

    private final VoucherRepository voucherRepository;

    @Autowired
    public VoucherController(VoucherRepository voucherRepository) {
        this.voucherRepository = voucherRepository;
    }

    @PostMapping
    public Voucher createVoucher(@RequestBody Voucher voucher) {
        return voucherRepository.save(voucher);
    }

    @GetMapping("/{code}")
    public Voucher getVoucher(@PathVariable String code) throws BadRequestException {
        return voucherRepository.findByCode(code).orElseThrow(
                ()-> new BadRequestException("there is no voucher with this code")
        );
    }
}
