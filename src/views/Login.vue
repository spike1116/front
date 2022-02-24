<template>
    <div style="width: 100%; height: 100vh; background-color: darkslateblue; overflow:hidden">
        <div style="width: 400px; margin: 150px auto">
            <div style="color: #cccccc; font-size: 30px; text-align: center; padding:30px 0 ">学生管理系统</div>
            <el-form ref="form" :model="form" size="normal" :rules="rules">

                <el-form-item prop="username">

                    <el-input prefix-icon="User" v-model="form.id" placeholder="用户名"></el-input>
                </el-form-item>
                <el-form-item prop="password">

                    <el-input  prefix-icon="Lock" v-model="form.password" placeholder="密码" show-password></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button style = "width:100%" type="primary" @click="login">登陆</el-button>
                </el-form-item>
                <el-form-item>
                    <el-button style = "width:100%" type="primary" @click="$router.push('/register')">注册</el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<script>
    import request from "@/utils/request";


    export default {
        name: "Login",
        data(){
            return {
                form:{},
                rules: {
                    id: [
                        { required: true, message: '请输入用户名', trigger: 'blur'},
                    ],
                    password: [
                        { required: true, message: '请输入密码', trigger: 'blur'},
                    ],
                }
            }
        },

        methods:{
            login(){
                this.$refs['form'].validate((valid) => {
                    if (valid) {
                        request.post("/user/login",this.form).then(res => {
                            console.log(res)
                            if (res.code === '0') {
                                this.$message({
                                    type: "success",
                                    message: "登陆成功"
                                })
                                this.$router.push("/")  //登陆成功后进行页面跳转，跳转到主页
                            } else {
                                this.$message({
                                    type: "error",
                                    message: res.msg
                                })
                            }
                        })
                    }
                })
            }
        }
    }
</script>

<style scoped>
</style>