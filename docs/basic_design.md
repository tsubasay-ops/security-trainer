# Security-Trainer ドキュメント（個人スクラム開発）

> Sprint0: 環境整備＋基本設計  
> Sprint1以降: 実装＋詳細設計＋スプリントごとに更新

---

## 1. プロジェクト概要（要件定義）

- **プロジェクト名**: security-trainer
- **目的**: セキュリティ観点抽出力を鍛える学習アプリ
- **対象ユーザー**:
  - 自分
  - 同期エンジニア
  - 初学者
- **主要機能（MVP）**:
  - 問題画像の表示
  - クリックによる正誤判定
  - 解説表示
  - 再挑戦可能
  - 内部的に複数問題保持

---

## 2. 技術スタック

| カテゴリ | ツール |
|----------|-------|
| 言語 | Java 25 |
| フレームワーク | Spring Boot 3 |
| ビルド | Maven 3.9.12 |
| DB | H2（インメモリ） |
| フロント | Thymeleaf |
| IDE | VSCode |
| バージョン管理 | Git / GitHub Flow |
| 課題管理 | Jira Freeプラン |

---

## 3. アーキテクチャ（基本設計）

- **構造**: レイヤード構造（MVC）
  - Controller
  - Service
  - Model
  - Repository: Sprint1では未使用
- **データ保持方針**:
  - DB永続化はせず、Service内で仮データ保持
  - 再起動でデータは消える

---

## 4. ドメインモデル

### Problem
- id
- title
- imagePath
- List<VulnerabilityPoint>

### VulnerabilityPoint
- x
- y
- correct
- explanation

### ClickResult
- x
- y
- isCorrect

---

## 5. 画面フロー

```text
問題選択画面（index.html）
      │
      ▼
  問題画面（問題ごとに異なる）
      │
      ▼
正誤判定 → 解説表示
      │
      ▼
  再挑戦可能