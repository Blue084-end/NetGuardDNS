
# NetGuardDNS


# NetGuardDNS

NetGuardDNS là một ứng dụng Android kết hợp giữa [NetGuard](https://github.com/M66B/NetGuard) và [personalDNSfilter](https://github.com/PersonalDNSfilter/personalDNSfilter) nhằm cung cấp khả năng kiểm soát truy cập mạng theo ứng dụng và lọc DNS theo tên miền — tất cả trong một giao diện điều khiển trực quan.

---

## 🚀 Tính năng chính

- 🔐 **Chặn truy cập mạng theo ứng dụng** (Wi-Fi / Dữ liệu di động)
- 🌐 **Lọc DNS theo tên miền** (chặn quảng cáo, theo dõi, v.v.)
- 📊 **Ghi log truy vấn DNS và lưu lượng mạng**
- ⚙️ **Giao diện điều khiển dễ dùng với 3 tab chính**
- 🔁 **Tự động khởi động dịch vụ khi thiết bị bật**
- 📤 **Xuất cấu hình và danh sách tên miền**

---

## 📦 Cấu trúc repo

```plaintext
NetGuardDNS/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/eu/faircode/netguard/          # Mã nguồn chính
│   │   │   ├── res/layout/                         # Giao diện XML
│   │   │   ├── res/values/                         # Theme, màu, text
│   │   │   ├── res/menu/                           # Bottom navigation
│   │   │   ├── assets/                             # Cấu hình DNS filter
│   │   │   └── AndroidManifest.xml
├── native/                                         # (Tùy chọn) xử lý gói tin mạng
├── build.gradle
├── settings.gradle
├── README.md
