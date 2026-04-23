# Demo-QA-Automation

**QA Automation Testing Framework** - Repositori untuk automated testing menggunakan Katalon Studio dengan fokus pada Web UI testing.

## 📋 Daftar Isi

- [Tentang Proyek](#tentang-proyek)
- [Struktur Direktori](#struktur-direktori)
- [Persyaratan Sistem](#persyaratan-sistem)
- [Tools & Teknologi](#tools--teknologi)
- [Instalasi & Setup](#instalasi--setup)
- [Cara Menjalankan Test](#cara-menjalankan-test)
- [Konfigurasi](#konfigurasi)
- [Struktur Test](#struktur-test)
- [File Konfigurasi](#file-konfigurasi)
- [Kontribusi](#kontribusi)

---

## 🎯 Tentang Proyek

**Demo-QA-Automation** adalah proyek automation testing yang dirancang untuk melakukan QA (Quality Assurance) testing secara otomatis. Proyek ini menggunakan **Katalon Studio** sebagai framework utama dan fokus pada **Web UI Testing**.

### Fitur Utama:
- ✅ Automated Web UI Testing
- ✅ Object Repository Management
- ✅ Test Data Management
- ✅ HTML Test Reports
- ✅ Cross-browser Testing
- ✅ Groovy Script Support

---

## 📁 Struktur Direktori

```
Demo-QA-Automation/
│
├── 📂 Include/                          # Script dan konfigurasi utama
│   ├── scripts/
│   │   └── groovy/                     # Groovy scripts (custom code)
│   ├── features/                       # Feature files (BDD)
│   └── config/                         # Configuration files
│
├── 📂 Object Repository/                # Locators untuk Web Elements
│   └── [Object definitions]
│
├── 📂 Test Cases/                       # Test case definitions
│   └── [Individual test cases]
│
├── 📂 Test Suites/                      # Test suite groupings
│   └── [Test suite files]
│
├── 📂 Data Files/                       # Test data files
│   ├── testData.xlsx                   # Excel test data
│   └── [Other data files]
│
├── 📂 Profiles/                         # Execution profiles
│   └── [Profile configurations]
│
├── 📂 Scripts/                          # Custom scripts & utilities
│   └── [Script files]
│
├── 📂 .settings/                        # IDE settings
│
├── 📂 settings/                         # Project settings
│
├── 📄 TESTLAWEN.prj                    # Katalon Studio Project File
├── 📄 build.gradle                      # Gradle build configuration
├── 📄 console.properties                # Console & remote execution config
├── 📄 testData.xlsx                     # Test data spreadsheet
├── 📄 .gitignore                        # Git ignore rules
├── 📄 20260423_*.html                  # Test execution reports (HTML)
│
└── 📄 README.md                         # Dokumentasi ini
```

---

## 🛠 Persyaratan Sistem

### Minimum Requirements:
- **Java**: JDK 11 atau lebih tinggi
- **Gradle**: 7.0 atau lebih tinggi
- **Katalon Studio**: Version 11.0.1 atau lebih tinggi
- **RAM**: Minimum 4GB, recommended 8GB
- **OS**: Windows, macOS, atau Linux

### Browser Support:
- Chrome (Recommended)
- Firefox
- Edge
- Safari

---

## 🚀 Tools & Teknologi

| Tool | Versi | Fungsi |
|------|-------|--------|
| **Katalon Studio** | 11.0.1 | Main Test Framework |
| **Gradle** | Latest | Build Automation |
| **Groovy** | Latest | Scripting Language |
| **Java** | 11+ | Programming Language |
| **Excel** | XLSX | Test Data Storage |
| **HTML** | 5 | Test Reports |

### Dependencies (dari build.gradle):
```gradle
- Java plugin
- Katalon Gradle Plugin (0.1.2)
- Maven Central Repository
```

### Optional Dependencies (commented out):
```gradle
- rest-assured (API Testing)
- json-path (JSON Parsing)
- json-schema-validator (JSON Validation)
```

---

## 📦 Instalasi & Setup

### Step 1: Clone Repository
```bash
git clone https://github.com/OlopN70/Demo-QA-Automation.git
cd Demo-QA-Automation
```

### Step 2: Install Katalon Studio
1. Download dari [Katalon Official Website](https://katalon.com)
2. Install sesuai dengan OS Anda
3. Buka Katalon Studio

### Step 3: Open Project
1. Buka Katalon Studio
2. File → Open Project
3. Navigasi ke folder `Demo-QA-Automation`
4. Pilih file `TESTLAWEN.prj`

### Step 4: Setup Java & Gradle
```bash
# Verify Java installation
java -version

# Verify Gradle installation
gradle -v

# Install dependencies
gradle build
```

### Step 5: Configure Test Data
1. Edit file `testData.xlsx` dengan data test Anda
2. Pastikan format sesuai dengan test case requirements

---

## ▶️ Cara Menjalankan Test

### Option 1: Dari Katalon Studio GUI
```
1. Double-click Test Suite dari Test Suites folder
2. Klik "Run" button
3. Pilih browser/environment
4. Tunggu execution selesai
```

### Option 2: Dari Command Line
```bash
# Run specific test suite
gradle katalon -Pmetafilter="test-suite-name"

# Run all tests
gradle katalon

# Run dengan specific profile
gradle katalon -Pprofile="default"
```

### Option 3: Headless Mode (CI/CD)
```bash
# Run dalam mode headless (tanpa GUI browser)
gradle katalon -DheadlessBrowserExecution=true
```

---

## ⚙️ Konfigurasi

### File: `TESTLAWEN.prj`
**Deskripsi**: Project configuration file untuk Katalon Studio
- **Type**: WEBUI (Web UI Testing)
- **Edition**: ENTERPRISE
- **Version**: 11.0.1
- **Source Folders**: Include/scripts/groovy

### File: `console.properties`
**Deskripsi**: Configuration untuk console execution dan remote testing

**Konfigurasi Penting**:
```ini
# Katalon TestOps Integration
testOps.enabled=false                    # Set true untuk integrate dengan TestOps
testOps.serverUrl=                       # URL server TestOps
testOps.testRunName=                     # Test run name

# Remote Web Driver
remoteWebDriverType=Selenium             # Driver type (Selenium/Appium)
remoteWebDriverUrl=                      # URL untuk remote server

# Mobile Testing (Kobiton)
kobitonUserName=                         # Kobiton username
kobitonToken=                            # Kobiton token
kobitonDeviceId=                         # Device ID

# Appium Configuration
appiumDirectory=                         # Path ke Appium installation

# Cloud Services
testcloudEnvironmentId=                  # TestCloud environment
testcloudMobileId=                       # Mobile device ID
testcloudAppId=                          # App ID
```

### File: `build.gradle`
**Deskripsi**: Gradle build configuration

```gradle
plugins {
  id 'java'                              # Java plugin
  id "com.katalon.gradle-plugin" version "0.1.2"  # Katalon plugin
}

repositories {
  mavenCentral()                         # Maven repository
}

dependencies {
  // Uncomment untuk tambahan dependencies
  // compile 'io.rest-assured:rest-assured:3.2.0'
}
```

---

## 📐 Struktur Test

### Test Cases (`Test Cases/`)
Direktori ini berisi individual test cases yang dirancang untuk testing specific functionality.

**Struktur Test Case**:
- Test Step 1: Precondition
- Test Step 2-N: Actions
- Final Step: Verification/Assertions

### Test Suites (`Test Suites/`)
Grouping dari multiple test cases yang related.

**Format**:
- Sequential Execution
- Parallel Execution (optional)
- Setup/Teardown steps

### Object Repository (`Object Repository/`)
Central location untuk menyimpan locators dari UI elements.

**Best Practice**:
```xml
<!-- Example locator -->
<WebUI.Xpath>//*[@id='loginButton']</WebUI.Xpath>
<WebUI.CssSelector>.login-btn</WebUI.CssSelector>
```

### Test Data (`Data Files/`)
External data untuk parametrized testing.

**Format Supported**:
- Excel (.xlsx)
- CSV (.csv)
- Internal Variables

---

## 📊 File Konfigurasi

### `.gitignore`
```ignore
.gradle/                 # Gradle cache
bin/                     # Binary files
Reports/                 # Generated reports
Libs/                    # Library files
output/                  # Output files
build/                   # Build directory
.classpath               # Eclipse classpath
.project                 # Eclipse project
.cache/                  # Cache files
```

### Test Reports
```
20260423_113747.html     # Test execution report (1.3 MB)
20260423_114306.html     # Test execution report (1.4 MB)
20260423_120250.html     # Test execution report (3.1 MB)
```

**Cara Membuka Report**:
1. Klik test report HTML file
2. Browser akan membuka report dengan detailed info
3. Check failed tests, execution time, screenshots

---

## 📝 Workflow Pengembangan

### 1. Create Test Case
```
Test Cases → Right-click → New → Test Case
Define test steps dengan actions & verifications
```

### 2. Add Objects ke Repository
```
Object Repository → Right-click → Capture Object
atau manual add dengan XPath/CSS Selector
```

### 3. Create Test Suite
```
Test Suites → Right-click → New → Test Suite
Add test cases ke suite
```

### 4. Execute & Verify
```
Run test → Check report → Fix failures
```

### 5. Commit ke Repository
```bash
git add .
git commit -m "Add test cases for feature X"
git push origin main
```

---

## 🔍 Tips & Best Practices

### 1. Object Repository Management
- ✅ Gunakan meaningful names
- ✅ Organize by page/module
- ✅ Avoid hardcoded XPath
- ✅ Use CSS Selector when possible

### 2. Test Data Management
- ✅ Externalize test data
- ✅ Use Excel untuk complex data
- ✅ Implement data-driven testing
- ✅ Keep sensitive data secure

### 3. Script Writing
- ✅ Write reusable functions
- ✅ Add proper error handling
- ✅ Use meaningful variable names
- ✅ Add comments for clarity

### 4. Test Execution
- ✅ Run test suite regularly
- ✅ Check test reports
- ✅ Maintain test data
- ✅ Update locators when UI changes

---

## 🤝 Kontribusi

### Contribution Guidelines:
1. **Fork** repository
2. **Create** feature branch (`git checkout -b feature/AmazingFeature`)
3. **Commit** changes (`git commit -m 'Add AmazingFeature'`)
4. **Push** ke branch (`git push origin feature/AmazingFeature`)
5. **Open** Pull Request

### Code Standards:
- Follow Katalon coding standards
- Add comments dalam Groovy scripts
- Test sebelum submit
- Update documentation

---

## 🐛 Troubleshooting

| Masalah | Solusi |
|--------|--------|
| Test tidak run | Verify Katalon installation & project path |
| Locators tidak ditemukan | Update Object Repository dengan capture ulang |
| Gradle build error | Jalankan `gradle clean build` |
| Remote execution gagal | Check `console.properties` configuration |
| Test data not loaded | Verify Excel file path & format |

---

## 📞 Support & Resources

- **Katalon Documentation**: https://docs.katalon.com
- **GitHub Issues**: https://github.com/OlopN70/Demo-QA-Automation/issues
- **Katalon Forum**: https://forum.katalon.com

---

## 📄 Lisensi

Proyek ini bersifat **public** dan dapat digunakan untuk learning & development purposes.

---

## 📅 Project Information

- **Repository**: OlopN70/Demo-QA-Automation
- **Language**: HTML (99.1%), Other (0.9%)
- **Last Updated**: 2026-04-23
- **Owner**: [@OlopN70](https://github.com/OlopN70)
- **Visibility**: Public

---

**Last Updated**: April 23, 2026  
**Maintained by**: OlopN70
```

Saya telah membuat README yang komprehensif dengan struktur berikut:

## 📌 Highlights:

1. **Daftar Isi** - Navigasi mudah ke semua section
2. **Struktur Lengkap** - ASCII diagram direktori dengan penjelasan setiap folder
3. **Tools & Teknologi** - Tabel detail tools yang digunakan
4. **Setup Guide** - Step-by-step untuk instalasi
5. **Cara Menjalankan Test** - 3 opsi eksekusi (GUI, CLI, Headless)
6. **Konfigurasi Detail** - Penjelasan setiap file config
7. **Workflow Development** - Panduan membuat test case
8. **Best Practices** - Tips untuk menggunakan framework
9. **Troubleshooting** - Solusi masalah umum
10. **Professional Structure** - Emojis, formatting, dan organization yang rapi

README ini siap untuk dipush ke repository Anda! 🚀
