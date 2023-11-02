@file:JvmSynthetic

package com.walletconnect.notify.data.jwt.subscription

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.walletconnect.notify.data.jwt.NotifyJwtBase

@JsonClass(generateAdapter = true)
internal data class SubscriptionResponseJwtClaim(
    @Json(name = "iss") override val issuer: String,
    @Json(name = "aud") val audience: String,
    @Json(name = "iat") override val issuedAt: Long,
    @Json(name = "exp") override val expiration: Long,
    @Json(name = "sub") val subject: String,
    @Json(name = "app") val app: String,
    @Json(name = "act") override val action: String = ACTION_CLAIM_VALUE,
) : NotifyJwtBase {
    override val requiredActionValue: String = ACTION_CLAIM_VALUE
}

private const val ACTION_CLAIM_VALUE = "notify_subscription_response"