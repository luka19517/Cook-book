<template>
    <PVImage :src="logo" alt="logo"/>
</template>

<script>

export default {
    name: 'HomeComponent',
    data() {
        return{
            logo: require('../assets/logo.jpg')
        }
    }
}
</script>

