import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './CadastroEventosPage.jsx'; // Estilos específicos

function CadastroEventoPage() {
    const navigate = useNavigate();

    const [formData, setFormData] = useState({
        // Detalhes básicos do Evento
        title: '',
        description: '',
        eventDate: '', // Data principal do evento
        eventTime: '',
        location: '',
        price: '',
        imageUrl: '', // Para o banner de publicação e divulgação
        suggestedSlug: '',

        // Configurações de Submissão de Artigos
        aceitaArtigos: false,
        prazoSubmissaoInicial: '',
        instrucoesAutores: '',
        tipoAvaliacao: 'simples-cego', // Opções: 'simples-cego', 'duplo-cego', 'aberta'

        // Configurações de Avaliação e Prazos
        prazoRetornoAvaliacao: '',
        permiteSubmissaoCorrigida: false,
        prazoSubmissaoFinalCorrigida: '',
    });

    const [isLoading, setIsLoading] = useState(false);
    const [feedback, setFeedback] = useState({ message: '', type: '' });

    const handleChange = (e) => {
        const { name, value, type, checked } = e.target;
        setFormData(prevData => ({
            ...prevData,
            [name]: type === 'checkbox' ? checked : value,
        }));
    };

    // Habilita/Desabilita campos dependendo de outros checkboxes
    // Por exemplo, prazoSubmissaoFinalCorrigida só é relevante se permiteSubmissaoCorrigida for true
    const isSubmissaoFinalDisabled = !formData.permiteSubmissaoCorrigida;
    const areArtigoFieldsDisabled = !formData.aceitaArtigos;

    const handleSubmit = async (e) => {
        e.preventDefault();
        setIsLoading(true);
        setFeedback({ message: '', type: '' });

        const eventDataToSend = { ...formData };
        // Lógica para limpar campos desabilitados antes de enviar, se necessário
        if (!formData.aceitaArtigos) {
            eventDataToSend.prazoSubmissaoInicial = '';
            eventDataToSend.instrucoesAutores = '';
            eventDataToSend.tipoAvaliacao = '';
            eventDataToSend.prazoRetornoAvaliacao = '';
            eventDataToSend.permiteSubmissaoCorrigida = false;
            eventDataToSend.prazoSubmissaoFinalCorrigida = '';
        } else if (!formData.permiteSubmissaoCorrigida) {
            eventDataToSend.prazoSubmissaoFinalCorrigida = '';
        }


        try {
            console.log('Dados do Evento para Cadastro:', eventDataToSend);
            // Simulação de chamada de API (substitua pelo seu fetch/axios real)
            await new Promise(resolve => setTimeout(resolve, 1500));

            setFeedback({
                message: `Evento "${formData.title}" e suas configurações foram cadastrados com sucesso! (Simulado)`,
                type: 'success',
            });
            // Limpar o formulário (opcional)
            // setFormData({ ...valoresIniciais... }); 
            // navigate('/'); // Opcional: redirecionar
        } catch (error) {
            console.error('Erro ao cadastrar evento (simulado):', error);
            setFeedback({
                message: 'Falha ao cadastrar o evento. Verifique os dados e tente novamente.',
                type: 'error',
            });
        } finally {
            setIsLoading(false);
        }
    };

    return (
        <div className="cadastro-evento-page">
            <div className="cadastro-evento-container">
                <h1>Novo Evento</h1>

                {feedback.message && (
                    <div className={`feedback-message ${feedback.type}`}>
                        {feedback.message}
                    </div>
                )}

                <form onSubmit={handleSubmit} className="cadastro-evento-form">
                    {/* Seção 1: Detalhes Principais do Evento */}
                    <fieldset className="form-fieldset">
                        <legend className="fieldset-legend">Detalhes Principais do Evento</legend>
                        <div className="form-group">
                            <label htmlFor="title">Título do Evento*</label>
                            <input type="text" id="title" name="title" className="form-control" value={formData.title} onChange={handleChange} required disabled={isLoading} />
                        </div>
                        <div className="form-group">
                            <label htmlFor="description">Descrição Completa*</label>
                            <textarea id="description" name="description" className="form-control" rows="5" value={formData.description} onChange={handleChange} required disabled={isLoading} />
                        </div>
                        <div className="form-row">
                            <div className="form-group">
                                <label htmlFor="eventDate">Data Principal do Evento*</label>
                                <input type="date" id="eventDate" name="eventDate" className="form-control" value={formData.eventDate} onChange={handleChange} required disabled={isLoading} />
                            </div>
                            <div className="form-group">
                                <label htmlFor="eventTime">Horário Principal</label>
                                <input type="time" id="eventTime" name="eventTime" className="form-control" value={formData.eventTime} onChange={handleChange} disabled={isLoading} />
                            </div>
                        </div>
                        <div className="form-group">
                            <label htmlFor="location">Local*</label>
                            <input type="text" id="location" name="location" className="form-control" value={formData.location} onChange={handleChange} required disabled={isLoading} />
                        </div>
                        <div className="form-group">
                            <label htmlFor="price">Preço/Inscrição (ex: R$ 50,00 ou Grátis)*</label>
                            <input type="text" id="price" name="price" className="form-control" value={formData.price} onChange={handleChange} required disabled={isLoading} />
                        </div>
                        <div className="form-group">
                            <label htmlFor="imageUrl">URL da Imagem do Banner (para publicação e divulgação)*</label>
                            <input type="url" id="imageUrl" name="imageUrl" className="form-control" placeholder="https://exemplo.com/banner-evento.png" value={formData.imageUrl} onChange={handleChange} required disabled={isLoading} />
                        </div>
                        <div className="form-group">
                            <label htmlFor="suggestedSlug">Identificador para Link (ex: nome-do-evento-ano)*</label>
                            <input type="text" id="suggestedSlug" name="suggestedSlug" className="form-control" value={formData.suggestedSlug} onChange={handleChange} required disabled={isLoading} />
                            <small>Será usado para criar o link da página do evento. Use letras minúsculas e hífens.</small>
                        </div>
                    </fieldset>

                    {/* Seção 2: Configuração para Submissão de Artigos */}
                    <fieldset className="form-fieldset">
                        <legend className="fieldset-legend">Submissão de Artigos</legend>
                        <div className="form-group checkbox-group">
                            <input type="checkbox" id="aceitaArtigos" name="aceitaArtigos" checked={formData.aceitaArtigos} onChange={handleChange} disabled={isLoading} />
                            <label htmlFor="aceitaArtigos" className="checkbox-label">Este evento aceitará submissão de artigos?</label>
                        </div>

                        {!areArtigoFieldsDisabled && (
                            <>
                                <div className="form-group">
                                    <label htmlFor="prazoSubmissaoInicial">Prazo para Submissão Inicial de Artigos*</label>
                                    <input type="date" id="prazoSubmissaoInicial" name="prazoSubmissaoInicial" className="form-control" value={formData.prazoSubmissaoInicial} onChange={handleChange} required={formData.aceitaArtigos} disabled={isLoading} />
                                </div>
                                <div className="form-group">
                                    <label htmlFor="instrucoesAutores">Instruções para Autores*</label>
                                    <textarea id="instrucoesAutores" name="instrucoesAutores" className="form-control" rows="5" placeholder="Detalhe as normas, formato esperado, etc." value={formData.instrucoesAutores} onChange={handleChange} required={formData.aceitaArtigos} disabled={isLoading} />
                                </div>
                                <div className="form-group">
                                    <label htmlFor="tipoAvaliacao">Tipo de Avaliação dos Artigos*</label>
                                    <select id="tipoAvaliacao" name="tipoAvaliacao" className="form-control" value={formData.tipoAvaliacao} onChange={handleChange} required={formData.aceitaArtigos} disabled={isLoading}>
                                        <option value="simples-cego">Simples-cego (Avaliador não sabe quem é o autor)</option>
                                        <option value="duplo-cego">Duplo-cego (Nem autor nem avaliador se conhecem)</option>
                                        <option value="aberta">Aberta (Todos se conhecem)</option>
                                    </select>
                                </div>
                                <div className="form-group">
                                    <label htmlFor="prazoRetornoAvaliacao">Prazo para Retorno da Avaliação*</label>
                                    <input type="date" id="prazoRetornoAvaliacao" name="prazoRetornoAvaliacao" className="form-control" value={formData.prazoRetornoAvaliacao} onChange={handleChange} required={formData.aceitaArtigos} disabled={isLoading} />
                                </div>
                                <div className="form-group checkbox-group">
                                    <input type="checkbox" id="permiteSubmissaoCorrigida" name="permiteSubmissaoCorrigida" checked={formData.permiteSubmissaoCorrigida} onChange={handleChange} disabled={isLoading} />
                                    <label htmlFor="permiteSubmissaoCorrigida" className="checkbox-label">Permitir submissão final corrigida (após avaliação)?</label>
                                </div>
                                {!isSubmissaoFinalDisabled && (
                                    <div className="form-group">
                                        <label htmlFor="prazoSubmissaoFinalCorrigida">Prazo para Submissão Final Corrigida*</label>
                                        <input type="date" id="prazoSubmissaoFinalCorrigida" name="prazoSubmissaoFinalCorrigida" className="form-control" value={formData.prazoSubmissaoFinalCorrigida} onChange={handleChange} required={formData.permiteSubmissaoCorrigida} disabled={isLoading} />
                                    </div>
                                )}
                            </>
                        )}
                    </fieldset>

                    <button type="submit" className="submit-button" disabled={isLoading}>
                        {isLoading ? 'Salvando Configurações...' : 'Salvar Configurações do Evento'}
                    </button>
                </form>
            </div>
        </div>
    );
}

export default CadastroEventoPage;