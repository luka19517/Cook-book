<template>
    <PVImage class="center" :src="logo" alt="logo" />
</template>

<script>

export default {
    name: 'HomeComponent',
    data() {
        return {
            logo: require('../assets/logo.jpg')
        }
    }
}
</script>

<style>
.center {
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: 50%;
}
</style>

