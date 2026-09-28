# UTEShop (Demo Đăng nhập Spring Boot)

Ứng dụng Spring Boot 3 demo chức năng xác thực tùy chỉnh với Spring Security. Cho phép người dùng đăng nhập bằng username hoặc email ở cùng một ô nhập liệu.

## Công nghệ sử dụng
* Java 17
* Spring Boot 3.x
* Spring Security 6 
* Spring Data JPA
* Hibernate
* MapStruct (Mapping DTO)
* Thymeleaf (Templates & Layout Dialect)
* SQL Server

## Chức năng
* **Custom Login**: Đăng nhập qua `email` HOẶC `username` trên 1 trường duy nhất.
* **Thymeleaf Layouts**: Cấu trúc giao diện tái sử dụng (`layout.html`, `header.html`, `home.html`).
* **Cấu hình Security**: Mã hóa mật khẩu (`BCrypt`), bảo vệ CSRF, phân quyền truy cập theo đường dẫn.
* **Tự động khởi tạo DB**: Tự động tạo `ROLE_ADMIN`, `ROLE_USER` và tài khoản test mặc định khi chạy lần đầu.

## Cài đặt

1. **Cấu hình Database**: 
   Tạo database trống tên `webst4` trong SQL Server.
   ```sql
   CREATE DATABASE webst4;
   ```

2. **Cấu hình biến môi trường**:
   Cập nhật thông tin kết nối trong file `.env` ở thư mục gốc:
   ```properties
   DB_URL=jdbc:sqlserver://localhost:1433;databaseName=webst4;encrypt=false;trustServerCertificate=true;sslProtocol=TLSv1.2;characterEncoding=UTF-8
   DB_USERNAME=sa
   DB_PASSWORD=mật_khẩu_của_bạn
   
   DDL_AUTO=create-drop  # Đổi thành 'update' ở những lần chạy sau để giữ data
   SHOW_SQL=true
   SERVER_PORT=8080
   ```

3. **Chạy ứng dụng**:
   Dùng maven để tải thư viện và chạy:
   ```bash
   mvn spring-boot:run
   ```

## Tài khoản Test mặc định
Khi ứng dụng khởi động lần đầu, `DataInitializer` sẽ tạo tài khoản mẫu sau:
* **Email:** `user01@gmail.com`
* **Username:** `user01`
* **Mật khẩu:** `123456`

## URL Ứng dụng
* Trang chủ: `http://localhost:8080/`
* Đăng nhập: `http://localhost:8080/login`
* Đăng xuất qua phương thức POST tới `/logout` (được tích hợp sẵn trong header).
