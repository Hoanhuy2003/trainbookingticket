package com.project.tickettrainbooking.dtos;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NguoiDungDTO {

    @JsonProperty("ten_dang_nhap")
    private String tenDangNhap;

    @JsonProperty("mat_khau")
    private String matKhau;

    @JsonProperty("role")
    private String role;

    @JsonProperty("ho_ten")
    private String hoTen;

    @JsonProperty("so_dien_thoai")
    private String soDienThoai;

    @JsonProperty("email")
    private String email;

    @JsonProperty("cccd")
    private String cccd;
}
