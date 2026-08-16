# Java Web Application

Java Servlet / JSP を使用して作成した Web アプリケーションです。  
ログイン機能、アンケート入力、アンケート一覧表示など、  
Web アプリの基本機能を一通り実装しています。

---

## 📌 使用技術

- Java 8+
- Servlet / JSP
- JSTL
- MySQL
- JDBC
- HTML / CSS / JavaScript
- Eclipse (Dynamic Web Project)
- Git / GitHub

---

## 📁 ディレクトリ構成
src/main/java/model/...   # ビジネスロジック・DAO・DTO
src/main/webapp/WEB-INF/view/...  # JSP 画面
src/main/webapp/html/...  # 静的ページ
src/main/webapp/js/...    # JavaScript

---

## 🔐 主な機能

### 1. ログイン機能
- ユーザーID / パスワード認証  
- セッション管理

### 2. アンケート入力
- 入力チェック（JavaScript）  
- DB への保存

### 3. アンケート一覧表示
- 全件取得  
- JSP でテーブル表示

---

## 📝 画面一覧

- login.jsp  
- input_survey.jsp  
- show_all_survey.jsp  
- logout.jsp  
- error.html  
- finish.html  

---

## 🚀 セットアップ方法（ローカル実行）

1. Eclipse で Dynamic Web Project を作成  
2. `src/main/java` と `src/main/webapp` を配置  
3. MySQL にテーブルを作成  
4. Tomcat を起動して `http://localhost:8080/java-web-app` にアクセス

---

## 📮 作者

**yuhei-dev-tec**

