<template>
    <h2> COOK BOOK</h2>
    <PVImage :src="logo" alt="logo"/>
</template>

<script>

export default {
    name: 'HomeComponent',
    logo: require('../assets/logo.jpg')
}
</script>

