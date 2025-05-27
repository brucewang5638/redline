## 技术栈组合推荐
### 轻量级项目（快速启动）
Vite + React + React Router + Tailwind CSS + TypeScript
优点：开箱即用，适合小型应用或原型开发。
工具链：Vite + TypeScript + Tailwind CSS（通过插件集成）。
### 中大型项目（企业级）
Vite + React + React Router + Redux Toolkit + React Query + Material-UI + TypeScript
优点：类型安全、状态管理清晰、数据请求高效。
工具链：Vite + TypeScript + ESLint + Prettier（代码规范）。
### 极致开发体验（现代方案）
Vite + React + TanStack Router + Zustand + Tailwind CSS + TypeScript
优点：文件驱动路由、类型安全、轻量状态管理。
适用场景：需要自动代码拆分和类型推导的现代项目。
### 避免过度设计
无需引入后端框架 ：如 Next.js 的 App Router（除非需要 SSR/SSG）。
避免冗余依赖 ：根据项目复杂度选择工具（如小型项目无需 Redux）。
保持技术栈一致性 ：避免混合多种状态管理方案（如同时用 Context API 和 Redux）。