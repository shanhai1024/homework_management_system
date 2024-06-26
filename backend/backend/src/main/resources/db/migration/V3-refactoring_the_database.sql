-- 创建 departments 表
CREATE TABLE departments (
                             id INT PRIMARY KEY AUTO_INCREMENT COMMENT '系部唯一标识',     -- 系部唯一标识
                             department_name VARCHAR(100) NOT NULL COMMENT '系部名称', -- 系部名称
                             head_of_department INT COMMENT '系主任ID'                -- 系主任ID
);

-- 创建 teachers 表
CREATE TABLE teachers (
                          id INT PRIMARY KEY AUTO_INCREMENT COMMENT '教师唯一标识',     -- 教师唯一标识
                          name VARCHAR(100) NOT NULL COMMENT '教师姓名',            -- 教师姓名
                          department_id INT COMMENT '系部ID',                     -- 系部ID
                          contact_info VARCHAR(255) COMMENT '联系方式',             -- 联系方式
                          specialization VARCHAR(100) COMMENT '专业领域'           -- 专业领域
);

-- 创建 student_classes 表
CREATE TABLE student_classes (
                                 id INT PRIMARY KEY AUTO_INCREMENT COMMENT '班级唯一标识',     -- 班级唯一标识
                                 class_name VARCHAR(100) NOT NULL COMMENT '班级名称',      -- 班级名称
                                 teacher_id INT COMMENT '班主任ID',                        -- 班主任ID
                                 department_id INT COMMENT '系部ID'                      -- 系部ID
);

-- 创建 students 表
CREATE TABLE students (
                          id INT PRIMARY KEY AUTO_INCREMENT COMMENT '学生唯一标识',     -- 学生唯一标识
                          name VARCHAR(100) NOT NULL COMMENT '学生姓名',            -- 学生姓名
                          age INT COMMENT '学生年龄',                               -- 学生年龄
                          gender VARCHAR(10) COMMENT '学生性别',                    -- 学生性别
                          class_id INT COMMENT '班级ID',                          -- 班级ID
                          contact_info VARCHAR(255) COMMENT '联系方式'              -- 联系方式
);

-- 创建 teacher_classes 表
CREATE TABLE teacher_classes (
                                 id INT PRIMARY KEY AUTO_INCREMENT COMMENT '唯一标识',     -- 唯一标识
                                 teacher_id INT COMMENT '教师ID',                        -- 教师ID
                                 class_id INT COMMENT '班级ID'                          -- 班级ID
);

-- 创建 persons 表
CREATE TABLE persons (
                         id INT PRIMARY KEY AUTO_INCREMENT COMMENT '人员唯一标识',     -- 人员唯一标识
                         name VARCHAR(100) NOT NULL COMMENT '姓名',            -- 姓名
                         role VARCHAR(50) NOT NULL COMMENT '角色（例如学生、教师等）',             -- 角色（例如学生、教师等）
                         department_id INT COMMENT '系部ID',                     -- 系部ID
                         contact_info VARCHAR(255) COMMENT '联系方式'              -- 联系方式
);

-- 创建 careers 表
CREATE TABLE careers (
                         id INT PRIMARY KEY AUTO_INCREMENT COMMENT '职位唯一标识',     -- 职位唯一标识
                         title VARCHAR(100) NOT NULL COMMENT '职位名称',           -- 职位名称
                         description TEXT COMMENT '职位描述',                      -- 职位描述
                         requirements TEXT COMMENT '职位要求',                     -- 职位要求
                         salary VARCHAR(50) COMMENT '薪资范围'                     -- 薪资范围
);

-- 创建 cafeteria_staff 表
CREATE TABLE cafeteria_staff (
                                 id INT PRIMARY KEY AUTO_INCREMENT COMMENT '唯一标识',     -- 唯一标识
                                 name VARCHAR(100) NOT NULL COMMENT '姓名',            -- 姓名
                                 role VARCHAR(50) NOT NULL COMMENT '职位',             -- 职位
                                 shift VARCHAR(50) COMMENT '班次',                     -- 班次
                                 contact_info VARCHAR(255) COMMENT '联系方式'              -- 联系方式
);

-- 创建 cafeterias 表
CREATE TABLE cafeterias (
                            id INT PRIMARY KEY AUTO_INCREMENT COMMENT '唯一标识',     -- 唯一标识
                            name VARCHAR(100) NOT NULL COMMENT '食堂名称',            -- 食堂名称
                            location VARCHAR(255) NOT NULL COMMENT '位置',        -- 位置
                            manager_id INT COMMENT '经理ID'                         -- 经理ID
);

-- 添加外键约束

-- departments 表外键
ALTER TABLE departments
    ADD FOREIGN KEY (head_of_department) REFERENCES teachers(id);

-- teachers 表外键
ALTER TABLE teachers
    ADD FOREIGN KEY (department_id) REFERENCES departments(id);

-- student_classes 表外键
ALTER TABLE student_classes
    ADD FOREIGN KEY (teacher_id) REFERENCES teachers(id),
ADD FOREIGN KEY (department_id) REFERENCES departments(id);

-- students 表外键
ALTER TABLE students
    ADD FOREIGN KEY (class_id) REFERENCES student_classes(id);

-- teacher_classes 表外键
ALTER TABLE teacher_classes
    ADD FOREIGN KEY (teacher_id) REFERENCES teachers(id),
ADD FOREIGN KEY (class_id) REFERENCES student_classes(id);

-- persons 表外键
ALTER TABLE persons
    ADD FOREIGN KEY (department_id) REFERENCES departments(id);

-- cafeterias 表外键
ALTER TABLE cafeterias
    ADD FOREIGN KEY (manager_id) REFERENCES cafeteria_staff(id);

-- 插入初始数据

-- 插入 departments 数据
INSERT INTO departments (department_name, head_of_department)
VALUES
    ('计算机科学与技术', NULL), -- 假设目前没有指定系主任
    ('电子信息工程', NULL),
    ('机械工程', NULL);

-- 插入 teachers 数据 (先插入一些教师，再更新 departments 表中的 head_of_department)
INSERT INTO teachers (name, department_id, contact_info, specialization)
VALUES
    ('李老师', 1, 'lilaoshi@example.com', '算法与数据结构'),
    ('王老师', 2, 'wanglaoshi@example.com', '通信工程'),
    ('张老师', 3, 'zhanglaoshi@example.com', '机械设计');

-- 更新 departments 表的 head_of_department
UPDATE departments SET head_of_department = 1 WHERE id = 1; -- 李老师是计算机科学与技术系主任
UPDATE departments SET head_of_department = 2 WHERE id = 2; -- 王老师是电子信息工程系主任
UPDATE departments SET head_of_department = 3 WHERE id = 3; -- 张老师是机械工程系主任

-- 插入 student_classes 数据
INSERT INTO student_classes (class_name, teacher_id, department_id)
VALUES
    ('2024级计算机一班', 1, 1),
    ('2024级电子信息一班', 2, 2),
    ('2024级机械一班', 3, 3);

-- 插入 students 数据
INSERT INTO students (name, age, gender, class_id, contact_info)
VALUES
    ('学生A', 20, '男', 1, 'studenta@example.com'),
    ('学生B', 21, '女', 2, 'studentb@example.com'),
    ('学生C', 22, '男', 3, 'studentc@example.com');

-- 插入 teacher_classes 数据
INSERT INTO teacher_classes (teacher_id, class_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);

-- 插入 persons 数据
INSERT INTO persons (name, role, department_id, contact_info)
VALUES
    ('学生A', '学生', 1, 'studenta@example.com'),
    ('学生B', '学生', 2, 'studentb@example.com'),
    ('李老师', '教师', 1, 'lilaoshi@example.com'),
    ('王老师', '教师', 2, 'wanglaoshi@example.com');

-- 插入 careers 数据
INSERT INTO careers (title, description, requirements, salary)
VALUES
    ('软件开发工程师', '负责开发和维护公司软件产品', '熟练掌握Java和SQL', '10,000-15,000元/月'),
    ('硬件工程师', '负责硬件设计与调试', '熟练掌握电子电路设计', '12,000-18,000元/月');

-- 插入 cafeteria_staff 数据
INSERT INTO cafeteria_staff (name, role, shift, contact_info)
VALUES
    ('食堂员工A', '厨师', '早班', 'staffa@example.com'),
    ('食堂员工B', '服务员', '晚班', 'staffb@example.com');

-- 插入 cafeterias 数据
INSERT INTO cafeterias (name, location, manager_id)
VALUES
    ('学生食堂', 'A楼1层', 1), -- 假设 '食堂员工A' 是经理
    ('教工食堂', 'B楼2层', 2); -- 假设 '食堂员工B' 是经理
