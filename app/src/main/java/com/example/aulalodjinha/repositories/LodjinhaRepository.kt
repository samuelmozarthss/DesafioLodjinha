package br.com.lodjinha.repositories

import com.example.aula2_iesb_lodjinha.api.LodjinhaService
import com.example.aula2_iesb_lodjinha.models.GetBannerResponse
import com.example.aula2_iesb_lodjinha.models.GetCategoriaResponse
import com.example.aula2_iesb_lodjinha.models.GetMaisVendidosResponse
import com.example.aulalodjinha.utils.ResponseWrapper

class LodjinhaRepository(
    private val service: LodjinhaService
) {

    suspend fun getBanner(): ResponseWrapper<GetBannerResponse> {
        service.getBanner()?.let {
            if (it.body() != null) {
                return ResponseWrapper.Success(it.body()!!)
            }
        }
        return ResponseWrapper.Error("Erro ao carregar os banners")
    }

    suspend fun getCategoria(): ResponseWrapper<GetCategoriaResponse> {
        service.getCategoria()?.let {
            if (it.body() != null) {
                return ResponseWrapper.Success(it.body()!!)
            }
        }
        return ResponseWrapper.Error("Erro ao carregar as categorias")
    }

    suspend fun getMaisVendidos(): ResponseWrapper<GetMaisVendidosResponse> {
        service.getMaisVendidos()?.let {
            if (it.body() != null) {
                return ResponseWrapper.Success(it.body()!!)
            }
        }
        return ResponseWrapper.Error("Erro ao carregar os mais vendidos")
    }
}