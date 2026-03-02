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

### 1. Problem（問題）
- **id**: 問題を識別する一意のID
- **title**: 問題のタイトル
- **imagePath**: 問題画像のパス
- **vulnerabilityPoints**: 問題内の脆弱箇所リスト（`List<VulnerabilityPoint>`）

---

### 2. VulnerabilityPoint（脆弱箇所）
- **x**: クリック判定用 X座標
- **y**: クリック判定用 Y座標
- **correct**: 正解フラグ（true / false）
- **explanation**: 解説テキスト

---

### 3. ClickResult（クリック結果）
- **x**: クリックした X座標
- **y**: クリックした Y座標
- **isCorrect**: 正解かどうかの判定結果（true / false）

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
