package com.zhigaras.navigation

import com.zhigaras.login.domain.LoginNavigation
import com.zhigaras.payments.domain.PaymentsNavigation

interface Navigation : LoginNavigation, PaymentsNavigation, StartNavigation