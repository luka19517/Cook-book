<template>
    <header class="header">
        <div class="logo-box">
            <img class="logo" src="../assets/img/logo.png" alt="Logo" /> 
        </div>

        <div class="text-box">
            <!-- span odvaja  -->
            <h1 class="heading-primary">
                <span class="heading-primary-main">Cookbook</span>
                <span class="heading-primary-sub">book of foods</span>

            </h1>

        </div>


    </header>
</template>

<script>

export default {
    name: 'HomeComponent',
    data() {
        return {
            logo: require('../assets/img/logo.png')
        }
    }
}
</script>

<style>
  @import '../assets/css/home_style.css';
</style>


