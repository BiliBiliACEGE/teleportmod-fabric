中文版 | Chinese Version
🔧 模组名称：TeleportMod
📌 核心功能

/tpx <x> <y> <z> 精准坐标传送
✅ 当前维度内任意坐标传送（支持绝对/相对/局部坐标）
✅ 6位小数精度（与原版/tp一致）
✅ 世界边界校验
🚫 不支持跨维度传送（需保持当前维度）

/tpl <玩家名> 玩家间传送
✅ 跨维度传送（自动跟随目标玩家维度）
✅ 保留目标玩家朝向角度
✅ 自动补全在线玩家列表

🎯 设计目标
为 原版生存服/轻量RPG服 提供灵活且安全的传送方案：

跨维度场景：通过 /tpl 快速集结队友（无论身处主世界、下界或末地）

精准定位：通过 /tpx 在同一维度内标记建筑坐标、探索路径

❓ 常见问题 Q&A
Q1：为何 /tpx 不支持跨维度传送？
A：刻意设计！为保证公平性：

避免滥用：跨维度坐标需考虑比例转换（如主世界→下界为 8:1），直接输入坐标易导致误操作

简化逻辑：专注解决同一维度内的精准传送需求，跨维度请使用 /tpl 跟随目标玩家

Q2：为何支持 1.20 和 1.21+ 等多个版本？
A：实际需求驱动：

1.20 用户：主流整合包/模组服仍广泛使用 1.20

1.21+ 用户：适配官方最新版本，确保长期兼容性

代码架构：核心逻辑与版本API解耦，维护成本低

English Version
🔧 Mod Name: TeleportMod
📌 Core Features

/tpx <x> <y> <z> Precision Teleport
✅ Intra-dimension teleport (supports absolute/relative/local coords)
✅ 6-decimal precision (matches vanilla /tp)
✅ World border validation
🚫 No cross-dimension TP (limited to current dimension)

/tpl <player> Player-to-Player TP
✅ Cross-dimension teleport (auto-follow target's dimension)
✅ Preserve target's rotation
✅ Auto-suggest online players

🎯 Design Purpose
Provide vanilla survival/light-RPG servers with flexible & secure teleportation:

Cross-Dimension: Use /tpl to gather teammates across Overworld/Nether/End

Precision Navigation: Use /tpx for coordinate marking within the same dimension

❓ FAQ
Q1: Why does /tpx not support cross-dimension?
A: Intentional design for fairness:

Prevent abuse: Cross-dimension coord scaling (e.g., 8:1 in Nether) risks miscalculations

Simplify usage: Focus on intra-dimension precision; use /tpl for cross-dimension

Q2: Why support both 1.20 and 1.21+?
A: Practical needs:

1.20 Users: Most modpacks/servers still use 1.20

1.21+ Users: Future-proof for latest versions

Code Design: Version-agnostic core with API isolation
