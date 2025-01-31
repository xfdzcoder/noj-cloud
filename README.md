# 【项目简介】
NOJ——智能判题系统是一款新型的在线判题平台，它不仅继承了传统 OJ 系统的所有核心功能，还通过引入AI大语言模型，实现了传统 OJ 所无法达到的智能化功能。NOJ 的设计理念源自NIO（New OJ）的概念，旨在为用户提供更加智能、高效、全面的编程练习与评测环境。无论是 AI 辅助的智能判题、答疑功能，还是丰富的题库与多样的用户管理功能，NOJ 都力求让每位编程爱好者和开发者获得最佳的学习与使用体验。

# 【技术架构】
NOJ——智能判题系统基于Spring Boot框架开发，结合了前沿的前后端分离技术，前端采用Vue.js进行开发，后端则使用Spring Boot框架与MyBatis ORM框架实现数据持久化。数据库层采用MySQL来存储与管理数据，以确保数据的安全性与查询效率。系统同时引入了多个AI平台接口，通过微服务架构进行管理，保证系统的高扩展性与易维护性。NOJ 系统的设计不仅考虑到功能的实现，还重视系统的性能与安全性，通过代码沙箱与多语言支持为用户提供了稳定、快速的代码运行环境。

# 【功能模块】

1. 代码沙箱模块 
   1. 多语言支持：NOJ 支持多种编程语言的在线编译与执行，满足不同用户的需求。
   2. 安全性支持：通过代码沙箱技术，保证用户提交代码在隔离的环境中运行，防止恶意代码攻击。
   3. 资源消耗查看：用户可以实时查看代码的内存、时间等资源消耗，帮助优化代码性能。
   4. 多模式支持：
      - 核心方法模式：用户仅需实现特定的方法，NOJ 将自动处理输入输出。
      - ACM模式：用户需自行处理输入输出，适用于复杂的编程竞赛场景。

2. AI 辅助模块
   1. 多 AI 平台支持：NOJ 集成了多个主流AI平台，提供多种智能服务。
   2. AI 判题：通过AI模型分析代码逻辑，提供更加灵活与智能的判题服务。
   3. AI 答疑：用户可以与AI进行互动，获取编程问题的解答与建议。
   4. AI 代码纠错：AI将自动识别用户代码中的错误并提供修正建议，帮助用户快速改进代码。

3. 题库管理模块
   1. 搜索功能：用户可以通过关键词快速搜索题库中的题目。
   2. Excel导入导出：支持题目数据的批量导入与导出，方便管理员维护题库。
   3. 随机答题模式：系统可随机生成题目供用户练习，提升综合能力。
   4. 顺序背题模式：用户可按顺序浏览题库中的题目，有助于系统化学习。
   5. 积分规则：用户完成题目后可获得积分，积分可用于兑换奖励。
   6. 会员规则：提供不同等级的会员制度，会员可享有专属题库与服务。

4. 用户管理模块
   1. 动态多角色支持：系统支持多个用户角色，并可根据需要动态调整权限。
   2. 角色管理：管理员可管理下级用户的权限与功能访问。
   3. 积分管理：管理员可查看与调整用户的积分情况，并管理积分相关的奖励机制。

5. 社区板块模块
   1. 帖子管理：用户可以发布、浏览与评论技术帖子，参与社区讨论。
   2. 评论系统：支持对帖子与题目进行评论，增强用户互动性。
   3. 标签功能：用户可以为帖子与题目添加标签，便于分类与搜索。

