// Android emulator: http://10.0.2.2:8080/api ; iOS simulator: http://localhost:8080/api
// Physical phone: replace with your computer's LAN IP, e.g. http://192.168.1.5:8080/api
export const API_BASE_URL = 'http://10.0.2.2:8080/api';
async function request(path, options={}) {
  const response = await fetch(`${API_BASE_URL}${path}`, { headers: {'Content-Type':'application/json', ...(options.headers||{})}, ...options });
  if (!response.ok) { const body=await response.json().catch(()=>({message:'Request failed'})); throw new Error(body.message || `HTTP ${response.status}`); }
  if (response.status===204) return null;
  return response.json();
}
export const getTransactions=(type='ALL')=>request(`/transactions${type==='ALL'?'':`?type=${type}`}`);
export const getSummary=()=>request('/transactions/summary');
export const createTransaction=(data)=>request('/transactions',{method:'POST',body:JSON.stringify(data)});
export const updateTransaction=(id,data)=>request(`/transactions/${id}`,{method:'PUT',body:JSON.stringify(data)});
export const deleteTransaction=(id)=>request(`/transactions/${id}`,{method:'DELETE'});
